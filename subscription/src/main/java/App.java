	
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.subcription.controller.SubscriptionController;


public class App {

 

    public static void main(String[] args) {

            ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

           SubscriptionController bean = context.getBean(SubscriptionController.class);
          
   		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
   		
   		when(mockRequest.getAttribute("orderDetails")).thenReturn("123456789012345678901234567890");
   		when(mockRequest.getAttribute("length")).thenReturn("25");
           bean.subscribe(mockRequest);
           
           when(mockRequest.getAttribute("orderDetails")).thenReturn("1234567890");
      		when(mockRequest.getAttribute("length")).thenReturn("5");
              bean.subscribe(mockRequest);
              
              when(mockRequest.getAttribute("orderDetails")).thenReturn("123456789012345678901234567890");
        		when(mockRequest.getAttribute("length")).thenReturn("31");
                bean.subscribe(mockRequest);
           
            context.close();

    }

}
