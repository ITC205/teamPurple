package datamanagement;

/**
 * Data structure for a given grade and the minimum mark it requires.
 */
public class Grade
{
  //============================================================================
  // Variables
  //============================================================================



  private String code_;
  private float minimumMarkRequired_;



  //============================================================================
  // Constructors
  //============================================================================



  public Grade(String code, float minimumMarkRequired)
  {
    code_ = code;
    minimumMarkRequired_ = minimumMarkRequired;
  }



  //============================================================================
  // Getters & setters
  //============================================================================



  public String getCode()
  {
    return code_;
  }



  public float getMinimumMarkRequired()
  {
    return minimumMarkRequired_;
  }



  public void setCode(String code)
  {
    code_ = code;
  }



  public void setMinimumMarkRequired(float minimumMarkRequired)
  {
    minimumMarkRequired_ = minimumMarkRequired;
  }

}
