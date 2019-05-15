import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean{

	@Override
	public Object getObject() throws Exception {
		return new Employee(1,"jerry");
	}

	@Override
	public Class getObjectType() {
		return Employee.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
