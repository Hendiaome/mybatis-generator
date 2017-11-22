package com.hendiaome.gen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class Main1 {

	private JFrame frame;
	private JTextField textDataUrl;
	private JPanel panel;
	private JLabel userName;
	private JTextField TextuserName;
	private JTextField textPassword;
	private JLabel password;
	private JTextField packsName;
	private JTable table;
	private JButton btncontroller;
	private JButton btnservice;
	private JButton btndaoMapper;
	private DefaultTableModel model;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel_3;
	private JButton button;
	private JLabel label_3;
	private JComboBox comboBox;
	private JLabel lblCreateByHendiaome;
	private JPanel panel_4;
	private JLabel label_4;
	private JPanel panel_5;
	private JLabel label_5;
	private JProgressBar progressBar;
	private JLabel label_7;
	private JLabel lblcom;
	public static int pro = 0;
	
	//连接配置
	/*private String url1 = "jdbc:mysql://localhost:3306/ccx_scenic";
	private String user1 = "root";
	private String password1 = "123456";*/
	public static String url1 = "";
	public static String user1 = "";
	public static String password1 = "";
	static InputStream conf = null;
	static InputStream confUser = null;
	static Properties properties = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			conf = new FileInputStream(System.getProperty("user.home")+"\\db.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("read jar conf");
			conf = Main1.class.getResourceAsStream("/config/db.properties");
			int n = 0;
			
			try {
				FileOutputStream out = new FileOutputStream(System.getProperty("user.home")+"\\db.properties");
				byte[] buff = new byte[128];
			
				while (-1 !=  (n=conf.read(buff))) {
					out.write(buff, 0, n);
				}
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		try {
			confUser = new FileInputStream(System.getProperty("user.home")+"\\db.properties");
			if (null != confUser) {
				properties = new Properties();
				try {
					properties.load(confUser);
					Main1.url1 = properties.getProperty("url");
					Main1.user1 = properties.getProperty("user");
					Main1.password1 = properties.getProperty("pwd");
					confUser.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 window = new Main1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(Integer.decode("#F0F7FC")));
		frame.setBackground(new Color(Integer.decode("#F0F7FB")));
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		frame.setSize(476, 522);
		int x = (int)(toolkit.getScreenSize().getWidth()- frame.getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-frame.getHeight())/2;
		frame.setLocation(x, y);
		//frame.setBounds(300, 400, 562, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(Integer.decode("#D1E6F5")));;
		panel.setBounds(0, 34, 460, 139);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel dataUrl = new JLabel("数据url:");
		dataUrl.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		dataUrl.setBounds(10, 13, 48, 15);
		panel.add(dataUrl);
		
		textDataUrl = new JTextField(url1);
		textDataUrl.setBounds(66, 10, 374, 18);
		panel.add(textDataUrl);
		textDataUrl.setColumns(10);
		
		userName = new JLabel("用户名:");
		userName.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		userName.setBounds(10, 41, 48, 15);
		panel.add(userName);
		
		TextuserName = new JTextField(user1);
		TextuserName.setColumns(10);
		TextuserName.setBounds(66, 38, 93, 15);
		panel.add(TextuserName);
		
		textPassword = new JTextField(password1);
		textPassword.setColumns(10);
		textPassword.setBounds(66, 66, 93, 16);
		panel.add(textPassword);
		
		password = new JLabel("密  码:");
		password.setBounds(10, 69, 48, 15);
		panel.add(password);
		
		button = new JButton("测试连接");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				jdbcConnect();
			}
		});
		button.setBounds(10, 99, 149, 30);
		panel.add(button);
		
		label_3 = new JLabel("数据库类型");
		label_3.setBounds(207, 41, 87, 15);
		panel.add(label_3);
		
		comboBox = new JComboBox();
		comboBox.addItem("MySQL");
		/*comboBox.addItem("Oracle");
		comboBox.addItem("SQLServer");*/
		comboBox.setBounds(284, 38, 70, 21);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(Integer.decode("#D1E6F5")));
		panel_1.setBounds(0, 208, 460, 59);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("输入包名:");
		label.setBounds(10, 10, 89, 15);
		panel_1.add(label);
		
		packsName = new JTextField();
		packsName.setColumns(10);
		packsName.setBounds(103, 10, 93, 15);
		panel_1.add(packsName);
		
		lblcom = new JLabel("必须填");
		lblcom.setBounds(206, 10, 244, 15);
		panel_1.add(lblcom);
		

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(Integer.decode("#D1E6F5")));
		panel_2.setBounds(1, 304, 460, 127);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		String[] columnNames = {"表名","主键类型","操作"};   //列名
		//String [][]tableVales={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}}; //数据
		model = new DefaultTableModel(null, columnNames);
		table = new JTable(model);
		table.setBounds(1, 27, 329, 43);
		table.setModel(model);
		table.setBorder(BorderFactory.createEtchedBorder());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 281, 127);
		panel_2.add(scrollPane);
		
		
		
		btncontroller = new JButton("生成controller");
		btncontroller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				if("".equals(packsName.getText())) {
					JOptionPane.showMessageDialog(null, "一级包名必须填写", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(0 == table.getSelectedRows().length) {
					JOptionPane.showMessageDialog(null, "至少选择一张表", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				new Thread(){  
					boolean flag = true;
		            public void run(){  
		               while(true==flag) {
		            	   try {
		            		Thread.sleep(100);
							progressBar.setValue(pro);
							//System.out.println("set "+pro);
							if(100 == pro) {
								pro = 0;
								flag =false;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		               }
		               progressBar.setString("Controller完成");
		            }  
		        }.start();  
		        new Thread() {
		        	public void run() {GeneCode.genController(progressBar, table, packsName.getText());};
		        }.start();
				
			}
		});
		btncontroller.setBounds(308, 10, 132, 23);
		panel_2.add(btncontroller);
		
		
		btnservice = new JButton("生成service");
		btnservice.setBounds(308, 54, 132, 23);
		panel_2.add(btnservice);
		
		btndaoMapper = new JButton("生成逆向工程");
		btndaoMapper.setToolTipText("生成Model Mapper Xml Dao");
		btndaoMapper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				if("".equals(packsName.getText())) {
					JOptionPane.showMessageDialog(null, "包名必须填写", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(0 == table.getSelectedRows().length) {
					JOptionPane.showMessageDialog(null, "至少选择一张表", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				new Thread(){  
					boolean flag = true;
		            public void run(){  
		               while(true==flag) {
		            	   try {
		            		Thread.sleep(100);
							progressBar.setValue(pro);
							//System.out.println("set "+pro);
							if(100 == pro) {
								pro = 0;
								flag =false;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		               }
		               progressBar.setString("逆向工程完成");
		            }  
		        }.start();  
		        new Thread() {
		        	public void run() {GeneCode.genMapper(progressBar, packsName.getText(), table, textDataUrl.getText(), TextuserName.getText(), textPassword.getText());};
				
		        }.start();
		       }
		});
		btndaoMapper.setBounds(308, 94, 132, 23);
		panel_2.add(btndaoMapper);
		
		label_2 = new JLabel("生成规则配置");
		label_2.setBounds(20, 134, 102, 15);
		frame.getContentPane().add(label_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(0, 0, 460, 37);
		panel_3.setBackground(new Color(Integer.decode("#D1E6F5")));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		label_1 = new JLabel("数据库配置");
		label_1.setBounds(10, 10, 121, 15);
		panel_3.add(label_1);
		
		lblCreateByHendiaome = new JLabel("Create by Hendiaome @2017");
		lblCreateByHendiaome.setBounds(262, 440, 188, 33);
		frame.getContentPane().add(lblCreateByHendiaome);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(new Color(209, 230, 245));
		panel_4.setBounds(0, 176, 460, 37);
		frame.getContentPane().add(panel_4);
		
		label_4 = new JLabel("规则配置");
		label_4.setBounds(10, 10, 121, 15);
		panel_4.add(label_4);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(new Color(209, 230, 245));
		panel_5.setBounds(0, 269, 460, 37);
		frame.getContentPane().add(panel_5);
		
		label_5 = new JLabel("生成操作");
		label_5.setBounds(10, 10, 121, 15);
		panel_5.add(label_5);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(141, 10, 282, 14);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true); 
		panel_5.add(progressBar);
		
		label_7 = new JLabel("进度：");
		label_7.setBounds(103, 10, 45, 15);
		panel_5.add(label_7);
		btnservice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				if("".equals(packsName.getText())) {
					JOptionPane.showMessageDialog(null, "包名必须填写", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(0 == table.getSelectedRows().length) {
					JOptionPane.showMessageDialog(null, "至少选择一张表", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				new Thread(){  
					boolean flag = true;
		            public void run(){  
		               while(true==flag) {
		            	   try {
		            		Thread.sleep(100);
							progressBar.setValue(pro);
							//System.out.println("set "+pro);
							if(100 == pro) {
								pro = 0;
								flag =false;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		               }
		               progressBar.setString("Service完成");
		            }  
		        }.start();  
		    new Thread(){
		    	public void run() {GeneCode.genService(progressBar, table, packsName.getText());};
		    }.start();
			}
		});
	}
	
	private Object jdbcConnect() {
		if("".equals(textDataUrl.getText())) {
			JOptionPane.showMessageDialog(null, "请输入数据库url", "提示", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if("".equals(TextuserName.getText())) {
			JOptionPane.showMessageDialog(null, "请输入数据库登录名", "提示", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if("".equals(textPassword.getText())) {
			JOptionPane.showMessageDialog(null, "请输入数据库密码", "提示", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		//
		try {
			FileOutputStream out = new FileOutputStream(System.getProperty("user.home")+"\\db.properties");
			properties.setProperty("url", textDataUrl.getText());
			properties.setProperty("user", TextuserName.getText());
			properties.setProperty("pwd", textPassword.getText());
			properties.store(out, "update pro");
			out.close();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		//
		new Thread(){  
			boolean flag = true;
            public void run(){  
               while(true==flag) {
            	   try {
            		Thread.sleep(100);
					progressBar.setValue(pro);
					//System.out.println("set "+pro);
					if(100 == pro) {
						pro = 0;
						flag =false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
               }
               progressBar.setString("数据库连接完成");
            }  
        }.start();  
        new Thread(){
        	public void run() {
        		//
        		try {
        			String driver = "com.mysql.jdbc.Driver";
        			Class.forName(driver);  
        	        Connection conn = DriverManager.getConnection(textDataUrl.getText(), TextuserName.getText(), textPassword.getText());  
        	        if (!conn.isClosed())  {
        	            System.out.println("Succeeded connecting to the Database!");  
        	        }
        	        else  {
        	            System.err.println("connect filed");  
        	            JOptionPane.showMessageDialog(null, "连接失败", "提示", JOptionPane.ERROR_MESSAGE);
        	        }
        	        // 获取所有表名  
        	        getTables(conn);  
        		} catch (Exception e) {
        			e.printStackTrace();
        			JOptionPane.showMessageDialog(null, "连接失败", "提示", JOptionPane.ERROR_MESSAGE);
        		}
        	};
        }.start();
		
		return null;
	}
	
	private void getTables(Connection conn) throws Exception {  
		DatabaseMetaData dbMetData = conn.getMetaData();  
        // mysql convertDatabaseCharsetType null  
        ResultSet rs = dbMetData.getTables(null, null, null,  new String[] { "TABLE", "VIEW" });  
  
        /*int rows = model.getRowCount();
        for(int i=0; i<rows-1; i++) {
        	model.removeRow(i);
        }*/
        rs.last(); //结果集指针知道最后一行数据  
        int len = rs.getRow();  
        System.out.println(len);         
        rs.beforeFirst();//将结果集指针指回到开始位置，这样才能通过while获取rs中的数据  
        int pro = 90/len;
		int n = 0;
        
		 Main1.pro = 20;
        while (rs.next()) { 
        	n++;
            if (rs.getString(4) != null  
                    && (rs.getString(4).equalsIgnoreCase("TABLE") || rs  
                            .getString(4).equalsIgnoreCase("VIEW"))) {  
                String tableName = rs.getString(3).toLowerCase();  
                System.out.print(tableName + "\t");  
                //model.addRow(new String[]{tableName,"选择"});
                
                //得到主键类型
                String pkName = "";
                ResultSet pkRSet = dbMetData.getPrimaryKeys(null, null, tableName);
                while(pkRSet.next()) {
                	/*System.err.println("****** Comment ******"); 
                	System.err.println("TABLE_CAT : "+pkRSet.getObject(1)); 
					System.err.println("TABLE_SCHEM: "+pkRSet.getObject(2)); 
					System.err.println("TABLE_NAME : "+pkRSet.getObject(3)); 
					System.err.println("COLUMN_NAME: "+pkRSet.getObject(4)); */
					pkName = (String) pkRSet.getObject(4);
					
				/*	System.err.println("KEY_SEQ : "+pkRSet.getObject(5)); 
					System.err.println("PK_NAME : "+pkRSet.getObject(6)); 
					System.err.println("****** ******* ******"); */
                }
                
                
                // 根据表名提前表里面信息：  
                ResultSet colRet = dbMetData.getColumns(null, "%", tableName,  "%");  
                while (colRet.next()) {  
                    String columnName = colRet.getString("COLUMN_NAME");  
                    String columnType = colRet.getString("TYPE_NAME");  
                    int datasize = colRet.getInt("COLUMN_SIZE");  
                    int digits = colRet.getInt("DECIMAL_DIGITS");  
                    int nullable = colRet.getInt("NULLABLE");  
                    
                    if(columnName.equals(pkName)) {
                    	System.out.println("主键类型"+columnType);
                    	model.addRow(new String[]{tableName,columnType,"选择"});
                    }
                    /* System.out.println("                "+columnName + " " + columnType + " "+  
                     datasize + " " + digits + " " + nullable);  */
                }  
                
               
  
            }  
            Main1.pro = n*pro;
        }
       Main1.pro = 100;
        
	}
}
