package datamanagement;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class ApplicationProperties
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  
  
  private static ApplicationProperties instance_ = null;
  
  private Properties properties_;


  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  
  
  private ApplicationProperties() 
  {
    properties_ = new Properties();
    try {
      properties_.load(new FileInputStream("Properties.prop"));
    } 
    catch (IOException e) {
      throw new RuntimeException("ApplicationProperties : " +
                                 "ApplicationProperties : " +
                                 "Could not read property file");
    }
  }


  
  //===========================================================================
  // Getters and Setters
  //===========================================================================
  
  
  
  public static ApplicationProperties getInstance() 
  {
    if (instance_ == null) { 
      instance_ = new ApplicationProperties(); 
    } 
    return instance_;
  }


  
  public Properties getProperties() 
  {
    return properties_;
  }

}
