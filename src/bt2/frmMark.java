/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2;
import dao.ClassDAO;
import dao.ClassObjectStudentDAO;
import dao.ObjectDAO;
import dao.StudentDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Class;
import pojo.ClassObjectStudent;
import pojo.Object;
import pojo.Student;

/**
 *
 * @author vomin
 */
public class frmMark extends javax.swing.JDialog {

    /**
     * Creates new form frmMark
     */
    public frmMark(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        List<Class> classes = ClassDAO.getClasses();
        
        if (classes != null && classes.size() > 0)
        {
            int size = classes.size();
            
            for (int i = 0; i < size; i++) {
                cboClass.addItem(classes.get(i).getCode());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cboClass = new javax.swing.JComboBox();
        cboObject = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        txtFail = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        lblFail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thống kê điểm");

        jButton1.setText("Nhập bảng điểm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClassActionPerformed(evt);
            }
        });

        cboObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboObjectActionPerformed(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MSSV", "Họ và tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Kết quả"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        jLabel3.setText("Đậu");

        jLabel4.setText("Rớt");

        txtPass.setText("0");
        txtPass.setEnabled(false);

        txtFail.setText("0");
        txtFail.setEnabled(false);

        lblPass.setText("0");

        lblFail.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboObject, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(cboClass, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFail)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboObject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFail))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean existed = false;
        FileInputStream f = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        File selectedFile = null;
        Scanner input = null;
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
        
        try {
            f = new FileInputStream(selectedFile.getAbsolutePath()); //tao bien tep f
            input = new Scanner(f,"UTF-8");
            
            while(input.hasNextLine()) //trong khi chưa het file
            {
                String line = input.nextLine(); //doc 1 dong
                if(line.trim()!="") //neu dong khong phai rong
                {
                    
                    String item[] = line.split(","); //cat cac thong tin cua line bang dau phay
                   
                    List<ClassObjectStudent> lst = ClassObjectStudentDAO.getObjects(item[0], item[1], item[2]);
                    
                    if (lst != null && lst.size() > 0)
                    {
                        ClassObjectStudent tmpSd = lst.get(0);
                    
                    tmpSd.setMark1(new BigDecimal(item[3]));
                    tmpSd.setMark2(new BigDecimal(item[4]));
                    tmpSd.setMark3(new BigDecimal(item[5]));
                    tmpSd.setMark4(new BigDecimal(item[6]));
                    tmpSd.setClassCode(item[0]);
                    
                    if (!ClassObjectStudentDAO.UpdateClassObjectStudent(tmpSd))
                    {
                        // fail
                        existed = true;
                    }
                    }
                }
            }
            if (!existed)
                JOptionPane.showMessageDialog(null, "Import thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Import thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(frmClass.class.getName()).log(Level.SEVERE, null, ex);
        }        finally {
            if (existed)
            {
                System.out.println("Tồn tại dữ liệu.");
            }
            if (f != null)
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(frmClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (input != null)
                input.close();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClassActionPerformed
        // TODO add your handling code here:
        String className = cboClass.getSelectedItem().toString();
        
        List<ClassObjectStudent> clsOcjStus = ClassObjectStudentDAO.getObjectByClass(className);
        
        if (clsOcjStus != null && clsOcjStus.size() > 0)
        {
            int size = clsOcjStus.size();
            
            ArrayList<String> tmpStr = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                
                ClassObjectStudent tmpC = clsOcjStus.get(i);
                if (!tmpStr.contains(tmpC.getObjectCode()))
                {
                    tmpStr.add(tmpC.getObjectCode());
                    Object tmpO = ObjectDAO.getObject(tmpC.getObjectCode());
                    
                    if (tmpO != null)
                    {
                        cboObject.addItem(tmpC.getObjectCode() + " - " + tmpO.getName());    
                    }
                }
            }
        }
    }//GEN-LAST:event_cboClassActionPerformed

    private void cboObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboObjectActionPerformed
        // TODO add your handling code here:
        String classCode = cboClass.getSelectedItem().toString();
        String objectCode = cboObject.getSelectedItem().toString();
        objectCode = objectCode.substring(0, objectCode.indexOf(" - "));
        
        List<ClassObjectStudent> clsObjStus = ClassObjectStudentDAO.getObjects(classCode, objectCode);
        
        if (clsObjStus != null && clsObjStus.size() > 0)
        {
            int size = clsObjStus.size();
            
            String [] ColumNames = {"STT", "MSSV", "Họ và tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Kết quả"};
            DefaultTableModel modeltable = new DefaultTableModel(null, ColumNames);
            int row = 0;
            int pass = 0;
            int fail = 0;
            for (int i = 0; i < size; i++) {
                Student tempStudent = StudentDAO.getStudent(clsObjStus.get(i).getStudentCode());
                String result = "";
                if (tempStudent != null)
                {
                    BigDecimal tmpBig = clsObjStus.get(i).getMark4();
                    if (tmpBig == null)
                    {
                        result = "N/A";
                        modeltable.insertRow(row, new java.lang.Object[]{row + 1, tempStudent.getCode(), tempStudent.getName(),
                        result, result, result, result,
                        result
                    });
                    }
                    else
                    {
                        if (tmpBig.compareTo(BigDecimal.valueOf(5)) > 0)
                        {
                            pass++;
                            result = "Đậu";
                        }
                        else
                        {
                            fail++;
                            result = "Rớt";
                        }
                        modeltable.insertRow(row, new java.lang.Object[]{row + 1, tempStudent.getCode(), tempStudent.getName(),
                        clsObjStus.get(i).getMark1(), clsObjStus.get(i).getMark2(), clsObjStus.get(i).getMark3(), clsObjStus.get(i).getMark4(),
                        result
                    });
                    }
                    
                    row++;
                }
            }
            
            
            tblStudent.removeAll();
            
            tblStudent.setModel(modeltable);
            
            txtPass.setText(Integer.toString(pass));
            txtFail.setText(Integer.toString(fail));
            if (pass + fail > 0)
            {
                lblPass.setText(Float.toString(pass/(pass + fail)));
                lblPass.setText(Float.toString(fail/(pass + fail)));
            }
        }
    }//GEN-LAST:event_cboObjectActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        
        frmChangeMark frm = new frmChangeMark(null, true);
        

        int row = tblStudent.getSelectedRow();
        String valueInCell = (String)tblStudent.getValueAt(row, 1);
        String valueInName = (String)tblStudent.getValueAt(row, 2);
        
        String objectCodeName = cboObject.getSelectedItem().toString();
        
        String objectCode = objectCodeName.substring(0, objectCodeName.indexOf(" - "));
        
        
        frm.setData(cboClass.getSelectedItem().toString(), objectCode, valueInCell, objectCodeName, valueInName, true);
        
        frm.setTitle("18424019  -  Chỉnh sửa điểm");
        
        frm.show();
        frm.dispose();
    }//GEN-LAST:event_tblStudentMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmMark dialog = new frmMark(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboClass;
    private javax.swing.JComboBox cboObject;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFail;
    private javax.swing.JLabel lblPass;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtFail;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
