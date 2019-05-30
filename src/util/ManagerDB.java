package util;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class ManagerDB {
   
   public static List<Object> getObjectList(String query, ArrayList<QueryParameter> queryParameters) {
      return ManagerDB.getObjectList(query, queryParameters, 0);
   }

   /**
    * Riceve una query in una stringa e un array di queryParameters e
    * restituisce una Lista di risultati
    */
   public static List<Object> getObjectList(String query, ArrayList<QueryParameter> queryParameters, int maxResults) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      List<Object> result = null;
      
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         Query q = session.createQuery(query);
         if (maxResults > 0) {
            q.setMaxResults(maxResults);
         }
         for (QueryParameter p : queryParameters) {
            q.setParameter(p.getNameParameter(), p.getO());
            // System.out.println("ManagerDB query "+p.toString());
         }
         result = q.list();
         // List<Event> events = ((List<Event>)(List<?>) (result));
         // for(Event e:events){
         // System.out.println("Sessioni "+e.getSession().getIdSession());
         // }
         tx.commit();
      } catch (HibernateException he) {
         if (tx != null) {
            tx.rollback();
         }
         throw he;
      } catch (Exception e) {
         e.printStackTrace();
         // System.out.println("Sospettato 1");
         if (tx != null) {
            tx.rollback();
         }
      } finally {
         session.close();
      }
      return result;
   }
   
   

   
   
    public static void saveObjectList(List<Object> list) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        int i = 0;

        for (Object o : list) {
            try {
                
                session.save(o);
                
                i++;
                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
                
            } catch (HibernateException he) {
                if (tx != null) {
                    tx.rollback();
                }
                throw he;
            }

        }
        tx.commit();
        session.close();
    }
  
    
   
//
//   public static List<Map<String,Parameter>> getParamMap(){
//        ArrayList<QueryParameter> queryParameters = new ArrayList<>();
//        Map<String, Parameter> par1 = new HashMap<>();
//        Map<String, Parameter> par2 = new HashMap<>();
//        
//        List<Map<String,Parameter>> paramListMap = new ArrayList<>();
//        
//        List<Object> parList1 = ManagerDB.getObjectList(constant.Query.GET_FIRST_PARAMETER, queryParameters);
//        
//        List<Object> parList2 = ManagerDB.getObjectList(constant.Query.GET_LAST_PARAMETER, queryParameters);
//        
//        for (Object p : parList1){
//            Parameter par = (Parameter) p;
//            par1.put(par.getCode(), par);
//        }
//        
//        for (Object p : parList2){
//            Parameter par = (Parameter) p;
//            par2.put(par.getCode(), par);
//        }
//        paramListMap.add(par1);
//        paramListMap.add(par2);
//        
//        return paramListMap;
//   }
   
   
   
}
