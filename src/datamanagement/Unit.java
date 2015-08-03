package datamanagement;

/**
 * default implementation of IUnit interface
 * applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit and calculates grades for this unit
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
   * creates a new unit
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
    this.setAssessmentWeights(i1, i2, i3);
    this.rs = rl == null ? new StudentUnitRecordList() : rl;
  }


  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * returns this unit's code
   * @return String code for unit
   */
  @Override
  public String getUnitCode() {
    return this.uc;
  }



  /**
   * returns this unit's name
   * @return String name of unit
   */
  @Override
  public String getUnitName()
  {
    return this.UN;
  }



  /**
   * returns the minimum mark to obtain a Pass grade in this unit
   * @return float value represents mark required for the grade
   */
  @Override
  public float getPsCutoff()
  {
    return this.co2;
  }



  /**
   * returns the minimum mark to obtain a Credit grade in this unit
   * @return float value represents mark required for the grade
   */
  @Override
  public float getCrCutoff()
  {
    return this.co1;
  }



  /**
   * returns the minimum mark to obtain a Distinction grade in this unit
   * @return float value represents mark required for the grade
   */
  @Override
  public float getDiCuttoff()
  {
    return this.co4;
  }



  /**
   * returns the minimum mark to obtain a High Distinction grade in this unit
   * @return float value represents mark required for the grade
   */
  @Override
  public float getHdCutoff()
  {
    return this.co3;
  }



  /**
   * returns minimum mark to qualify for an Alternative Assessment in this unit
   * @return float value represents mark required to qualify
   */
  @Override
  public float getAeCutoff()
  {
    return this.co5;
  }



  /**
   * returns the weighting for assessment one in this unit
   * @return integer weighting used for assignment one
   */
  @Override
  public int getAsg1Weight()
  {
    return this.a1;
  }



  /**
   * returns the weighting for assessment one in this unit
   * @return integer weighting used for assignment two
   */
  @Override
  public int getAsg2Weight()
  {
    return this.a2;
  }



  /**
   * returns the weighting for assessment one in this unit
   * @return integer weighting used for the exam
   */
  @Override
  public int getExamWeight()
  {
    return this.ex;
  }



  /**
   * returns the entire collection of student records for this unit
   * @return collection of student records (grades)
   */
  @Override
  public StudentUnitRecordList listStudentRecords()
  {
    return this.rs;
  }



  /**
   * returns a specified student's (single) record for this unit
   * @return student (grade) record for this unit
   */
  public IStudentUnitRecord getStudentRecord(int studentID)
  {
    for (IStudentUnitRecord r : this.rs) {
      if (r.getStudentID() == studentID)
        return r;
    }
    return null;
  }



  /**
   * sets the minimum mark to obtain a Pass grade in this unit
   * @param cutoff float value sets mark required for the grade
   */
  public void setPsCutoff1(float cutoff)
  {
    this.co2 = cutoff;
  }



  /**
   * sets the minimum mark to obtain a Credit grade in this unit
   * @param cutoff float value sets mark required for the grade
   */
  @Override
  public void setCrCutoff(float cutoff)
  {
    this.co1 = cutoff;
  }



  /**
   * sets the minimum mark to obtain a Distinction grade in this unit
   * @param cutoff float value sets mark required for the grade
   */
  public void setDiCutoff(float cutoff)
  {
    this.co4 = cutoff;
  }



  /**
   *  unused
   *  @param cutoff float value sets mark required for the grade
   */
  public void HDCutoff(float cutoff)
  {
    this.co3 = cutoff;
  }



  /**
   *  sets the minimum mark to obtain a High Distinction grade in this unit
   *  @param cutoff float value sets mark required for the grade
   */
  public void setHdCutoff(float cutoff)
  {
    this.co3 = cutoff;
  }



  /**
   * sets the minimum mark to qualify for an Alternative Assessment in this
   * unit
   * @param cutoff float value sets mark required to qualify for alternative
   *               assessment
   */
  public void setAeCutoff(float cutoff)
  {
    this.co5 = cutoff;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * adds a student record to the collection of student records for this unit
   * @param record student record to be added to collection of student records
   *               for this unit
   */
  @Override
  public void addStudentRecord(IStudentUnitRecord record)
  {
    this.rs.add(record);
  }



  /**
   * sets the weightings for the 3 assessments for this unit
   * @param a1 sets integer weighting used for assignment one
   * @param a2 sets integer weighting used for assignment one
   * @param ex sets integer weighting used for exam
   */
  @Override
  public void setAssessmentWeights(int a1, int a2, int ex)
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



  /**
   * checks the minimum marks specified for each grade are within bounds and
   * do not overlap
   * @param ps float minimum mark to obtain a Pass grade in this unit
   * @param cr float minimum mark to obtain a Credit grade in this unit
   * @param di float minimum mark to obtain a Distinction grade in this unit
   * @param hd float minimum mark to obtain a High Distinction grade in this
   *           unit
   * @param ae float minimum mark to qualify for an Alternative Assessment in
   *           this unit
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



  /**
   * calculates the correct grade for this unit (accounting for this unit's
   * assessment weightings and specified grade minimums)
   * @param f1 float student grade for assignment one in this unit
   * @param f2 float student grade for assignment two in this unit
   * @param f3 float student grade for the exam in this unit
   * @return final unit grade e.g. "HD"
   */
  @Override
  public String getGrade(float f1, float f2, float f3)
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


}