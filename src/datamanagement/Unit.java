package datamanagement;

/**
 * Default implementation of IUnit interface.
 * Applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit, calculates grades for this unit and adds student
 * records for this unit to the collection of student unit records.
 */
public class Unit
  implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  private String uc;
  private String UN;
  private float co2;
  private float co1;
  private float co4;
  private float co3;
  private float co5;
  private int a1;
  private int a2;
  private int ex;

  private StudentUnitRecordList rs;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates a new unit instance, applying specified marks required for grades
   * and weightings for assessments and references the collection of student
   * records.
   * @param UC this unit's code
   * @param un this unit's name
   * @param f1 minimum mark to obtain a Pass grade in this unit
   * @param f2 minimum mark to obtain a Credit grade in this unit
   * @param f3 minimum mark to obtain a Distinction grade in this unit
   * @param f4 minimum mark to obtain a High Distinction grade in this unit
   * @param f5 minimum mark to qualify for an Alternative Assessment in this unit
   * @param i1 weighting for assessment one in this unit
   * @param i2 weighting for assessment two in this unit
   * @param i3 weighting for the exam in this unit
   * @param rl collection of student records for this unit
   */
  public Unit(String UC, String un,
              float f1, float f2, float f3,
              float f4, float f5,
              int i1, int i2, int i3,
              StudentUnitRecordList rl)
  {
    this.uc = UC;
    this.UN = un;
    this.co2 = f1;
    this.co1 = f2;
    this.co4 = f3;
    this.co3 = f4;
    this.co5 = f5;
    this.setWeightsOfAssessments(i1, i2, i3);
    this.rs = rl == null ? new StudentUnitRecordList() : rl;
  }


  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitCode() {
    return this.uc;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitName()
  {
    return this.UN;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForAdditionalExamination()
  {
    return this.co5;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForPass()
  {
    return this.co2;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForCredit()
  {
    return this.co1;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForDistinction()
  {
    return this.co4;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForHighDistinction()
  {
    return this.co3;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentOne()
  {
    return this.a1;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentTwo()
  {
    return this.a2;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfExam()
  {
    return this.ex;
  }



  /**
   * {@inheritDoc}
   */
  public IStudentUnitRecord getStudentUnitRecord(int studentID)
  {
    for (IStudentUnitRecord r : this.rs) {
      if (r.getStudentID() == studentID)
        return r;
    }
    return null;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getStudentUnitRecordList()
  {
    return this.rs;
  }



  /**
   * {@inheritDoc}
   */
  public void setMinimumMarkForAdditionalExamination(float cutoff)
  {
    this.co5 = cutoff;
  }



  /**
   * {@inheritDoc}
   */
  public void setMinimumMarkForPass(float cutoff)
  {
    this.co2 = cutoff;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float cutoff)
  {
    this.co1 = cutoff;
  }



  /**
   * {@inheritDoc}
   */
  public void setMinimumMarkForDistinction(float cutoff)
  {
    this.co4 = cutoff;
  }



  /**
   *  unused
   */
  public void HDCutoff(float cutoff)
  {
    this.co3 = cutoff;
  }



  /**
   * {@inheritDoc}
   */
  public void setMinimumMarkForHighDistinction(float cutoff)
  {
    this.co3 = cutoff;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int a1, int a2, int ex)
  {
    if (a1 < 0 || a1 > 100 ||
          a2 < 0 || a2 > 100 ||
          ex < 0 || ex > 100 ) {
      throw new RuntimeException("Assessment weights cant be less than zero" +
                                   " or greater than 100");
    }
    if (a1 + a2 + ex != 100 ) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.a1 = a1;
    this.a2 = a2;
    this.ex = ex;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String calculateGrade(float f1, float f2, float f3)
  {
    float totalMark = f1 + f2 + f3;

    if (f1 < 0 || f1 > this.a1 ||
        f2 < 0 || f2 > this.a2 ||
        f3 < 0 || f3 > this.ex ) {
      throw new RuntimeException("marks cannot be less than zero or greater" +
                                 " than assessment weights");
    }

    if (totalMark < co5) {
      return "FL";
    }
    else if (totalMark < co2) {
      return "AE";
    }
    else if (totalMark < co1) {
      return "PS";
    }
    else if (totalMark < co4) {
      return "CR";
    }
    else if (totalMark < co3) {
      return "DI";
    }
    else {
      return "HD";
    }
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord record)
  {
    this.rs.add(record);
  }



  /**
   * Checks the minimum marks specified for each grade are within bounds and
   * do not overlap.
   * @param ps float Minimum mark to obtain a Pass grade in this unit.
   * @param cr float Minimum mark to obtain a Credit grade in this unit.
   * @param di float Minimum mark to obtain a Distinction grade in this unit.
   * @param hd float Minimum mark to obtain a High Distinction grade in this
   *           unit.
   * @param ae float Minimum mark to qualify for an Alternative Assessment in
   *           this unit.
   */
  private void setCutoffs(float ps, float cr, float di, float hd, float ae)
  {
    if (ps < 0 || ps > 100 ||
          cr < 0 || cr > 100 ||
          di < 0 || di > 100 ||
          hd < 0 || hd > 100 ||
          ae < 0 || ae > 100 ) {
      throw new RuntimeException("Assessment cutoffs cant be less than zero" +
                                   " or greater than 100");
    }
    if (ae >= ps) {
      throw new RuntimeException("AE cutoff must be less than PS cutoff");
    }
    if (ps >= cr) {
      throw new RuntimeException("PS cutoff must be less than CR cutoff");
    }
    if (cr >= di) {
      throw new RuntimeException("CR cutoff must be less than DI cutoff");
    }
    if (di >= hd) {
      throw new RuntimeException("DI cutoff must be less than HD cutoff");
    }


    
  }



}