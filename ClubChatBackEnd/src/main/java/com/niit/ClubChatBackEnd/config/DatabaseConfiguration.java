package com.niit.ClubChatBackEnd.config;
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ClubChatBackEnd.Dao.BlogDAO;
import com.niit.ClubChatBackEnd.DaoImplementation.BlogDAOImpl;
import com.niit.ClubChatBackEnd.Models.Blog;
import com.niit.ClubChatBackEnd.Models.Forum;


	@Configuration
	@ComponentScan("com.hk.AirChatBackEnd")
	@EnableTransactionManagement
public class DatabaseConfiguration {

		
			    @Autowired
			    @Bean(name="sF")
			    public SessionFactory sF(DataSource dataSource) {
			        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
			        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
			        
			        sessionBuilder.addProperties(getHibernateProperties());
			        sessionBuilder.addAnnotatedClass(Blog.class);
			        sessionBuilder.addAnnotatedClass(Forum.class);
			        /*  sessionBuilder.addAnnotatedClass(Supplier.class);
			        sessionBuilder.addAnnotatedClass(Category.class);
			        sessionBuilder.addAnnotatedClass(User.class);
			        sessionBuilder.addAnnotatedClass(Supplier.class);
			        sessionBuilder.addAnnotatedClass(Cart.class);
			        sessionBuilder.addAnnotatedClass(Order.class);*/
			        
			       
			        
			        return sessionBuilder.buildSessionFactory();
			    }
			    @Autowired
			    @Bean(name = "datasource") 
				    public DataSource dataSource() {
			        DriverManagerDataSource dataSource = new DriverManagerDataSource();
			        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=orcl)))");
			        dataSource.setUsername("merin");
			        dataSource.setPassword("merin");
			        System.out.println("DB success");
			        return dataSource;
			    }

			    private Properties getHibernateProperties() {
			        Properties properties = new Properties();
			        properties.put("hibernate.show_sql", "true");
			        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			        properties.put("hibernate.format_sql", "true");
			        
			  properties.put("hibernate.default_schema", "merin");
			        properties.put("hibernate.hbm2ddl.auto", "update");
			        properties.put("hibernate.connection.autocommit", true);
			        return properties;
			    }
			    @Autowired
			    @Bean(name="transactionmanager")
			        public HibernateTransactionManager txManager(SessionFactory sF) {
			                return new HibernateTransactionManager(sF);
			        }
			    @Autowired
			    @Bean(name="blogDao")
			    public BlogDAO getBlogDAO(SessionFactory sf )
			    {
			    	System.out.println("BlogDao object created");
			    	return new BlogDAOImpl(sf);
			    }
			  /*  @Autowired
			    	@Bean(name=blogDAO)*/
	 public static void main(String[] args) {
		Blog blog=new Blog();
 		blog.setBlogname("HK");
		blog.setBlogcontent("About Electric cars");
 		blog.setStatus("H");
		blog.setLikes(8);
blog.setDislikes(10);
    blog.setUsername("dd");		
    
		DatabaseConfiguration cd=new DatabaseConfiguration();
		System.out.println(cd.dataSource());
		Session session = cd.sF(cd.dataSource()).openSession();
	    session.beginTransaction();
	    session.save(blog);

	   
	    session.getTransaction().commit();
	    session.close();
		 
	}  
}
