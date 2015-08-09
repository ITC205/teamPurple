package datamanagement;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckGradeUserInterface extends javax.swing.JFrame implements IUnitLister,
		IStudentLister {
	private CheckGradeController ctl;
	private javax.swing.DefaultComboBoxModel uM;
	private javax.swing.DefaultComboBoxModel rM;
	float f1;
	float f2;
	float f3;
	Integer sid;

	public CheckGradeUserInterface(CheckGradeController ctl) {
		this.ctl = ctl;
		uM = new javax.swing.DefaultComboBoxModel(new String[0]);
		rM = new javax.swing.DefaultComboBoxModel(new String[0]);
		initComponents();
		selectUnitComboBox.setModel(uM);
		selectStudentComboBox.setModel(rM);
		errorMessageLabel.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		checkGradeTitleLabel = new javax.swing.JLabel();
		unitSelectionPanel = new javax.swing.JPanel();
		selectUnitComboBox = new javax.swing.JComboBox();
		studentSelectionPanel = new javax.swing.JPanel();
		selectStudentComboBox = new javax.swing.JComboBox();
		markDisplayPanel = new javax.swing.JPanel();
		assessmentOneLabel = new javax.swing.JLabel();
		assessmentTwoLabel = new javax.swing.JLabel();
		examLabel = new javax.swing.JLabel();
		assessementOneMarkTextField = new javax.swing.JTextField();
		assessmentTwoMarkTestField = new javax.swing.JTextField();
		examMarkTextField = new javax.swing.JTextField();
		changeButton = new javax.swing.JButton();
		gradeDisplayPanel = new javax.swing.JPanel();
		gradeDisplayLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		checkGradeTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkGradeTitleLabel.setText("Check Grade UI");

		unitSelectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit"));

		selectUnitComboBox.setModel(uM);
		selectUnitComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1ItemStateChanged(evt);
			}
		});

		javax.swing.GroupLayout gl_unitSelectionPanel = new javax.swing.GroupLayout(
				unitSelectionPanel);
		unitSelectionPanel.setLayout(gl_unitSelectionPanel);
		gl_unitSelectionPanel.setHorizontalGroup(gl_unitSelectionPanel.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_unitSelectionPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(selectUnitComboBox,
								javax.swing.GroupLayout.PREFERRED_SIZE, 185,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_unitSelectionPanel.setVerticalGroup(gl_unitSelectionPanel.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_unitSelectionPanel
						.createSequentialGroup()
						.addComponent(selectUnitComboBox,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		studentSelectionPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Student"));

		selectStudentComboBox.setModel(rM);
		selectStudentComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox2ItemStateChanged(evt);
			}
		});

		javax.swing.GroupLayout gl_studentSelectionPanel = new javax.swing.GroupLayout(
				studentSelectionPanel);
		studentSelectionPanel.setLayout(gl_studentSelectionPanel);
		gl_studentSelectionPanel.setHorizontalGroup(gl_studentSelectionPanel.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_studentSelectionPanel
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(selectStudentComboBox,
								javax.swing.GroupLayout.PREFERRED_SIZE, 185,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_studentSelectionPanel.setVerticalGroup(gl_studentSelectionPanel.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_studentSelectionPanel
						.createSequentialGroup()
						.addComponent(selectStudentComboBox,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		markDisplayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Marks"));

		assessmentOneLabel.setText("Asg1:");

		assessmentTwoLabel.setText("Asg2:");

		examLabel.setText("Exam:");

		assessementOneMarkTextField.setEditable(false);
		assessementOneMarkTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});

		assessmentTwoMarkTestField.setEditable(false);
		assessmentTwoMarkTestField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});

		examMarkTextField.setEditable(false);
		examMarkTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});

		changeButton.setText("Change");
		changeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		checkGradeButton = new javax.swing.JButton();
		
				checkGradeButton.setText("Check Grade");
				checkGradeButton.setActionCommand("checkGrade");
				checkGradeButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton3ActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout gl_markDisplayPanel = new javax.swing.GroupLayout(
				markDisplayPanel);
		gl_markDisplayPanel.setHorizontalGroup(
			gl_markDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_markDisplayPanel.createSequentialGroup()
					.addGroup(gl_markDisplayPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_markDisplayPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(assessmentOneLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(assessementOneMarkTextField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(assessmentTwoLabel))
						.addGroup(gl_markDisplayPanel.createSequentialGroup()
							.addGap(85)
							.addComponent(changeButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_markDisplayPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_markDisplayPanel.createSequentialGroup()
							.addComponent(assessmentTwoMarkTestField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(examLabel))
						.addComponent(checkGradeButton))
					.addGap(18)
					.addComponent(examMarkTextField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		gl_markDisplayPanel.setVerticalGroup(
			gl_markDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_markDisplayPanel.createSequentialGroup()
					.addGroup(gl_markDisplayPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(assessmentOneLabel)
						.addComponent(assessementOneMarkTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(assessmentTwoLabel)
						.addComponent(assessmentTwoMarkTestField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(examLabel)
						.addComponent(examMarkTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_markDisplayPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(changeButton)
						.addComponent(checkGradeButton))
					.addContainerGap())
		);
		markDisplayPanel.setLayout(gl_markDisplayPanel);

		gradeDisplayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));

		gradeDisplayLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		gradeDisplayLabel.setForeground(new java.awt.Color(255, 0, 0));
		gradeDisplayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		gradeDisplayLabel.setText("grade");

		javax.swing.GroupLayout gl_gradeDisplayPanel = new javax.swing.GroupLayout(
				gradeDisplayPanel);
		gradeDisplayPanel.setLayout(gl_gradeDisplayPanel);
		gl_gradeDisplayPanel.setHorizontalGroup(gl_gradeDisplayPanel.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				gradeDisplayLabel, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE));
		gl_gradeDisplayPanel.setVerticalGroup(gl_gradeDisplayPanel.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_gradeDisplayPanel.createSequentialGroup().addGap(34, 34, 34)
						.addComponent(gradeDisplayLabel)
						.addContainerGap(43, Short.MAX_VALUE)));
		
		errorMessageLabel = new JLabel();
		errorMessageLabel.setText("Error message");
		errorMessageLabel.setForeground(Color.RED);
		errorMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		saveButton = new javax.swing.JButton();
		
				saveButton.setText("Save");
				saveButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(errorMessageLabel, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(markDisplayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(unitSelectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(studentSelectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(gradeDisplayPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup()
							.addGap(157)
							.addComponent(checkGradeTitleLabel))
						.addGroup(layout.createSequentialGroup()
							.addGap(165)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(checkGradeTitleLabel)
					.addGap(13)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(unitSelectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentSelectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(gradeDisplayPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(markDisplayPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(saveButton)
					.addGap(11)
					.addComponent(errorMessageLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox1ItemStateChanged
		String cU = (String) selectUnitComboBox.getSelectedItem();
		Refresh3();
		clearStudents();
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			if (cU.equals((String) selectUnitComboBox.getItemAt(0))) {
				cU = "NONE";
			}
			ctl.unitSelected(cU);
		}
	}// GEN-LAST:event_jComboBox1ItemStateChanged

	private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jComboBox2ItemStateChanged
		Refresh3();
		String cS = (String) selectStudentComboBox.getSelectedItem();
		if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			if (cS.equals((String) selectStudentComboBox.getItemAt(0))) {
				sid = new Integer(0);
				ctl.studentSelected(sid);
			} else {
				sid = new Integer(cS.split("\\s")[0]);
			}
			ctl.studentSelected(sid);
		}
	}// GEN-LAST:event_jComboBox2ItemStateChanged

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		f1 = new Float(assessementOneMarkTextField.getText()).floatValue();
		f2 = new Float(assessmentTwoMarkTestField.getText()).floatValue();
		f3 = new Float(examMarkTextField.getText()).floatValue();
		//lblErrMsg.setText("");
		try {
			String s = ctl.checkGrade(f1, f2, f3);
			gradeDisplayLabel.setText(s);
		}
		catch (RuntimeException re) {
			errorMessageLabel.setText(re.getMessage());
		}
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		ctl.enableChangeMarks();
		gradeDisplayLabel.setText("");
		//lblErrMsg.setText("");
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyTyped
		gradeDisplayLabel.setText("");
		errorMessageLabel.setText("");
	}// GEN-LAST:event_jTextField1KeyTyped

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		float asg1 = new Float(assessementOneMarkTextField.getText()).floatValue();
		float asg2 = new Float(assessmentTwoMarkTestField.getText()).floatValue();
		float exam = new Float(examMarkTextField.getText()).floatValue();
		errorMessageLabel.setText("");
		try {
			ctl.saveGrade(asg1, asg2, exam);
			//jButton3ActionPerformed(null);
		}
		catch (RuntimeException re) {
			errorMessageLabel.setText(re.getMessage());
		}
	}// GEN-LAST:event_jButton2ActionPerformed

	public void clearUnits() {
		uM.removeAllElements();
		uM.addElement("<none selected>");
		clearStudents();
	}

	public void addUnit(IUnit u) {
		uM.addElement(u.getUnitCode());
	}

	public void setState1(boolean b) {
		selectUnitComboBox.setEnabled(b);
		errorMessageLabel.setText("");
	}

	public void clearStudents() {
		rM.removeAllElements();
		rM.addElement("<none selected>");
	}

	public void addStudent(IStudent student) {
		rM.addElement(student.getID().toString() + " : "
				+ student.getFirstName() + " " + student.getLastName());
	}

	public void setState2(boolean b) {
		selectStudentComboBox.setEnabled(b);
		errorMessageLabel.setText("");
	}

	public void setRecord(IStudentUnitRecord record) {
		assessementOneMarkTextField.setText(new Float(record.getAsg1()).toString());
		assessmentTwoMarkTestField.setText(new Float(record.getAsg2()).toString());
		examMarkTextField.setText(new Float(record.getExam()).toString());
		gradeDisplayLabel.setText("");
	}

	public void Refresh3() {
		assessementOneMarkTextField.setText("");
		assessmentTwoMarkTestField.setText("");
		examMarkTextField.setText("");
		gradeDisplayLabel.setText("");
		errorMessageLabel.setText("");
		assessementOneMarkTextField.setEditable(false);
		assessmentTwoMarkTestField.setEditable(false);
		examMarkTextField.setEditable(false);
	}

	public void setState3(boolean b) {
		checkGradeButton.setEnabled(b);
	}

	public void setState4(boolean b) {
		changeButton.setEnabled(b);
		// gradeLB.setText("");
	}

	public void setState5(boolean b) {
		assessementOneMarkTextField.setEditable(b);
		assessmentTwoMarkTestField.setEditable(b);
		examMarkTextField.setEditable(b);
	}

	public void setState6(boolean b) {
		saveButton.setEnabled(b);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton changeButton;
	private javax.swing.JButton checkGradeButton;
	private javax.swing.JButton saveButton;
	private javax.swing.JComboBox selectUnitComboBox;
	private javax.swing.JComboBox selectStudentComboBox;
	private javax.swing.JLabel checkGradeTitleLabel;
	private javax.swing.JLabel assessmentOneLabel;
	private javax.swing.JLabel assessmentTwoLabel;
	private javax.swing.JLabel examLabel;
	private javax.swing.JLabel gradeDisplayLabel;
	private javax.swing.JLabel errorMessageLabel;
	private javax.swing.JPanel unitSelectionPanel;
	private javax.swing.JPanel studentSelectionPanel;
	private javax.swing.JPanel markDisplayPanel;
	private javax.swing.JPanel gradeDisplayPanel;
	private javax.swing.JTextField assessementOneMarkTextField;
	private javax.swing.JTextField assessmentTwoMarkTestField;
	private javax.swing.JTextField examMarkTextField;
}