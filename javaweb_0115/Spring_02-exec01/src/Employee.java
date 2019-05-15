

public class Employee {
	
	private Integer  id ; 
	private String   lastName ;
	
	public Employee() {
		System.out.println("==>1. 调用构造器创建bean对象. ");
	}
	
	
	
	public Employee(Integer id, String lastName) {
		super();
		this.id = id;
		this.lastName = lastName;
	}



	/**
	 * 初始化的方法
	 */
	public void init() {
		System.out.println("==>3. 调用初始化方法. ");
	}
	
	/**
	 *销毁方法
	 */
	public void destroy() {
		System.out.println("==>5. 调用销毁方法. ");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("==>2. 调用set方法给对象的属性注入值. ");
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + "]";
	}
	
}
