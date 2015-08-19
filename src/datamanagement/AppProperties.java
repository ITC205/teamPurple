package datamanagement;

import java.util.*;
import java.io.*;



public class AppProperties
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private static AppProperties instance_ = null;
  private Properties properties_;


  //===========================================================================
  // Constructors
  //===========================================================================
  
  private AppProperties() 
  {
    properties_ = new Properties();
    try {
      properties_.load(new FileInputStream("Properties.prop"));
    } 
    catch (IOException e) {
      throw new RuntimeException("Could not read property file");
    }
  }


  //===========================================================================
  // Getters and Setters
  //===========================================================================
  
  
  public static AppProperties getInstance() 
  {
    if (instance_ == null) { 
      instance_ = new AppProperties(); 
    } 
    return instance_;
  }


  
  public Properties getProperties() 
  {
    return properties_;
  }

}
