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



  /**
   * Creates a new Grade instance, enabling Units to tailor the marks required
   * for a specific grade.
   * @param code String The code or abbreviation of the grade e.g. PS for Pass.
   * @param minimumMarkRequired float The minimum mark required to obtain the
   *                            given grade for the given Unit.
   */
  public Grade(String code, float minimumMarkRequired)
  {
    code_ = code;
    minimumMarkRequired_ = minimumMarkRequired;
  }



  //============================================================================
  // Getters & setters
  //============================================================================



  /**
   * Returns the code or abbreviation of the grade e.g. PS for Pass.
   * @return String Returns the code or abbreviation of the grade e.g. PS.
   */
  public String getCode()
  {
    return code_;
  }



  /**
   * Returns the minimum mark required to obtain the given grade for the given
   * Unit.
   * @return float The minimum mark required to obtain the
   *                given grade for the given Unit.
   */
  public float getMinimumMarkRequired()
  {
    return minimumMarkRequired_;
  }



  /**
   * Sets the code or abbreviation of the grade e.g. PS for Pass.
   * @param code  String The code or abbreviation of the grade e.g. PS.
   */
  public void setCode(String code)
  {
    code_ = code;
  }



  /**
   * Sets the minimum mark required to obtain the given grade for the given
   * Unit.
   * @param minimumMarkRequired float The minimum mark required to obtain the
   *                            given grade for the given Unit.
   */
  public void setMinimumMarkRequired(float minimumMarkRequired)
  {
    minimumMarkRequired_ = minimumMarkRequired;
  }

}
