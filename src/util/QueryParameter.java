package util;

/** Parameter of a HQL query */
public class QueryParameter {

	private String nameParameter;
	private Object o;

	public QueryParameter(String nameParameter, Object o) {
		this.nameParameter = nameParameter;
		this.o = o;
	}

	public String getNameParameter() {
		return nameParameter;
	}

	public void setNameParameter(String nameParameter) {
		this.nameParameter = nameParameter;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("\n");
		sb.append(this.nameParameter);
		sb.append(", value");
		sb.append(this.o);
		return sb.toString();
	}
}
