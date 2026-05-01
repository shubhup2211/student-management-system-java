package PracticeProject;

public class Marks {
	
	private int java;
	private int python;
	private int sql;
	private int react;
	
	public Marks(){
		
	}
	
	public Marks(int java, int python, int sql, int react){
		super();
		this.java=java;
		this.python=python;
		this.sql=sql;
		this.react=react;
	}
	

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getPython() {
		return python;
	}

	public void setPython(int python) {
		this.python = python;
	}

	public int getSql() {
		return sql;
	}

	public void setSql(int sql) {
		this.sql = sql;
	}

	public int getReact() {
		return react;
	}

	public void setReact(int react) {
		this.react = react;
	}

	public String toString() {
		return java+"\t"+python+"\t"+sql+"\t"+react;
	}
}