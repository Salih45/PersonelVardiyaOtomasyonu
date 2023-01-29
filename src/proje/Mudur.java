package proje;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Mudur extends JFrame {
	
	/**
	 * 
	 */
	private static Mudur frame;
	private JPanel contentPane;
	private JTextField txtAdi;
	private JTextField txtSoyad;
	private JTextField txtMaas;
	private JTextField txtBolum;
	private JTextField txtAdi1;
	private JTextField txtSoyad1;
	private JTextField txtMaas1;
	private JTextField txtMaas2;
	private JTextField txtSoyad2;
	private JTextField txtAdi2;
	private JTextField txtAdi3;
	private JTextField txtSoyad3;
	private JTextField txtKullaniciAdi;
	private JPasswordField txtSifre;
	private Integer seciliP;
	private JComboBox<Integer> cmbxPersonelNo;
	private JComboBox<Integer> cmbxPersonelNo1;
	private JComboBox<String> cmbxBolum;
	private JComboBox<String> cmbxYetki;
	private DefaultComboBoxModel<Integer> cmbxmdlPerBilgi;
	private DefaultComboBoxModel<Integer> cmbxmdlPerBilgi1;
	

	/**
	 * Frame Oluþturuluyor
	 */
	public Mudur() {
		
		setTitle("Müdür");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 220, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblhosgeldin = new JLabel(Giris.kullanici);
		lblhosgeldin.setHorizontalAlignment(SwingConstants.CENTER);
		lblhosgeldin.setBackground(Color.red);
		lblhosgeldin.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblhosgeldin.setBounds(664, 74, 110, 32);
		contentPane.add(lblhosgeldin);
		
		JButton btnyenipersonel = new JButton(" Yeni Personel");
		btnyenipersonel.setBounds(10, 121, 421, 95);
		btnyenipersonel.setHorizontalAlignment(SwingConstants.LEFT);
		btnyenipersonel.setIcon(new ImageIcon("icon\\yenipersonel.png"));
		btnyenipersonel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(btnyenipersonel);
		
		JButton btnmaasduzenle = new JButton(" Maa\u015F D\u00FCzenle");
		btnmaasduzenle.setBounds(10, 227, 421, 95);
		btnmaasduzenle.setHorizontalAlignment(SwingConstants.LEFT);
		btnmaasduzenle.setIcon(new ImageIcon("icon\\maas.png"));
		btnmaasduzenle.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(btnmaasduzenle);
	
		JButton btnpersonelbilgileri = new JButton(" Personel Bilgileri");
		btnpersonelbilgileri.setBounds(10, 15, 421, 95);
		btnpersonelbilgileri.setHorizontalAlignment(SwingConstants.LEFT);
		btnpersonelbilgileri.setIcon(new ImageIcon("icon\\personelbilgileri.png"));
		btnpersonelbilgileri.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(btnpersonelbilgileri);
		
		JButton btncikis = new JButton(" \u00C7\u0131k\u0131\u015F");
		btncikis.setBounds(614, 500, 160, 50);
		btncikis.addActionListener(new ActionListener() {//Çýkýþ iþlemleri yapýlýyor
			public void actionPerformed(ActionEvent e) {
				Giris.frame=new Giris();
				Giris.frame.setVisible(true);
				if (Giris.frame1==null) {//boþ olma kontrolü hata vermemesi için
					frame.dispose();
				} else {
					Giris.frame1.dispose();
				}
			}
		});
		btncikis.setIcon(new ImageIcon("icon\\cikis.png"));
		btncikis.setFont(new Font("Segoe Print", Font.BOLD, 20));
		contentPane.add(btncikis);
		
		JLabel lblHata = new JLabel("");
		lblHata.setBounds(493, 310, 140, 14);
		lblHata.setForeground(Color.red);
		lblHata.setVisible(false);
		contentPane.add(lblHata);
		
		JLabel lblHata1 = new JLabel("");
		lblHata1.setBounds(493, 250, 126, 14);
		lblHata1.setForeground(Color.red);
		lblHata1.setVisible(false);
		contentPane.add(lblHata1);
		
		JLabel lblHata2 = new JLabel("");
		lblHata2.setBounds(493, 190, 126, 14);
		lblHata2.setForeground(Color.red);
		lblHata2.setVisible(false);
		contentPane.add(lblHata2);
		
		JLabel lblPersonelNo = new JLabel("Personel No");
		lblPersonelNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPersonelNo.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblPersonelNo.setBounds(35, 72, 188, 50);
		lblPersonelNo.setVisible(false);
		contentPane.add(lblPersonelNo);
		
		JLabel lblAdi = new JLabel("Ad\u0131");
		lblAdi.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi.setBounds(102, 236, 115, 50);
		lblAdi.setVisible(false);
		contentPane.add(lblAdi);
		
		txtAdi = new JTextField();
		txtAdi.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtAdi.setVisible(false);
		txtAdi.setBounds(233, 236, 250, 50);
		txtAdi.setEnabled(false);
		txtAdi.setDisabledTextColor(Color.black);
		contentPane.add(txtAdi);
		txtAdi.setColumns(10);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131");
		lblSoyad.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoyad.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyad.setBounds(102, 296, 115, 50);
		lblSoyad.setVisible(false);
		contentPane.add(lblSoyad);
		
		JLabel lblMaas = new JLabel("Maaþý");
		lblMaas.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaas.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas.setBounds(102, 416, 115, 50);
		lblMaas.setVisible(false);
		contentPane.add(lblMaas);
		
		txtSoyad = new JTextField();
		txtSoyad.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtSoyad.setBounds(233, 296, 250, 50);
		txtSoyad.setEnabled(false);
		txtSoyad.setVisible(false);
		txtSoyad.setDisabledTextColor(Color.black);
		txtSoyad.setColumns(10);
		contentPane.add(txtSoyad);
		
		txtMaas = new JTextField();
		txtMaas.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtMaas.setBounds(233, 416, 250, 50);
		txtMaas.setEnabled(false);
		txtMaas.setVisible(false);
		txtMaas.setDisabledTextColor(Color.black);
		txtMaas.setColumns(10);
		contentPane.add(txtMaas);
		
		txtBolum = new JTextField();
		txtBolum.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtBolum.setVisible(false);
		txtBolum.setEnabled(false);
		txtBolum.setDisabledTextColor(Color.black);
		txtBolum.setBounds(233, 356, 250, 50);
		contentPane.add(txtBolum);
		txtBolum.setColumns(10);
		
		JLabel lblBolum = new JLabel("B\u00F6l\u00FCm\u00FC");
		lblBolum.setVisible(false);
		lblBolum.setHorizontalAlignment(SwingConstants.LEFT);
		lblBolum.setBounds(102, 356, 115, 50);
		lblBolum.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(lblBolum);
		
		JButton btnGeri = new JButton(" Geri");
		btnGeri.setVisible(false);
		btnGeri.setIcon(new ImageIcon("icon\\gerii.png"));
		btnGeri.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnGeri.setBounds(0, 0, 160, 50);
		contentPane.add(btnGeri);
		
		JLabel lblMaas1 = new JLabel("Maa\u015F\u0131");
		lblMaas1.setVisible(false);
		lblMaas1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaas1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas1.setBounds(24, 290, 188, 50);
		contentPane.add(lblMaas1);
		
		JLabel lblBolum1 = new JLabel("Bölümü");
		lblBolum1.setVisible(false);
		lblBolum1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBolum1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblBolum1.setBounds(24, 350, 188, 50);
		contentPane.add(lblBolum1);
		
		JLabel lblSoyad1 = new JLabel("Soyad\u0131");
		lblSoyad1.setVisible(false);
		lblSoyad1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoyad1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyad1.setBounds(24, 230, 188, 50);
		contentPane.add(lblSoyad1);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanýcý");
		lblKullaniciAdi.setVisible(false);
		lblKullaniciAdi.setHorizontalAlignment(SwingConstants.LEFT);
		lblKullaniciAdi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblKullaniciAdi.setBounds(24, 290, 188, 50);
		contentPane.add(lblKullaniciAdi);
		
		JLabel lblSifre = new JLabel("Þifre");
		lblSifre.setVisible(false);
		lblSifre.setHorizontalAlignment(SwingConstants.LEFT);
		lblSifre.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSifre.setBounds(24, 350, 188, 50);
		contentPane.add(lblSifre);
		
		JLabel lblYetki = new JLabel("Yetki");
		lblYetki.setVisible(false);
		lblYetki.setHorizontalAlignment(SwingConstants.LEFT);
		lblYetki.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblYetki.setBounds(24, 410, 188, 50);
		contentPane.add(lblYetki);
		
		JLabel lblAdi1 = new JLabel("Ad\u0131");
		lblAdi1.setVisible(false);
		lblAdi1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi1.setBounds(24, 170, 188, 50);
		contentPane.add(lblAdi1);
		
		txtAdi1 = new JTextField();
		txtAdi1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtAdi1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {//textfield sadece harf kontrolü yapýlýyor
				String Harfler="qwertyuýopðüasdfghjklþizxcvbnmöçQWERTYUIOPÐÜASDFGHJKLÞÝZXCVBNMÖÇ";
				try {
					for (int i = 0; i < Harfler.length(); i++) {//Ctrl+V,X,A,C veya silme tuþu veya space veya harf girildiðinde izin verilme
						if (ke.getKeyChar() == Harfler.charAt(i)||ke.getKeyCode() == KeyEvent.VK_BACK_SPACE||ke.getKeyCode()==KeyEvent.VK_SPACE||ke.getKeyCode()==KeyEvent.VK_CONTROL||((ke.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)&&(ke.getKeyCode() == KeyEvent.VK_C || ke.getKeyCode() ==KeyEvent.VK_V || ke.getKeyCode() ==KeyEvent.VK_X||ke.getKeyCode()==KeyEvent.VK_A)) {            	
							txtAdi1.setEditable(true);
							lblHata2.setText("");
							break;
			            }
						else {
							txtAdi1.setEditable(false);
			               lblHata2.setText("*Sadece Harfler(a-Z)");
			            }
					}
				} catch (Exception e) {
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {//Ctrl+V basýldýðýnda kopyalanan karakter kontrolleri
				if (e.getKeyCode() ==KeyEvent.VK_V && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0||e.getKeyCode()==KeyEvent.VK_V) {
						
						String Harfler="qwertyuýopðüasdfghjklþizxcvbnmöçQWERTYUIOPÐÜASDFGHJKLÞÝZXCVBNMÖÇ";
						String krktler=txtAdi1.getText();
						String yenikrktler="";
						for (int i = 0; i < krktler.length(); i++) {
							for (int j = 0; j < Harfler.length(); j++) {
								if (krktler.charAt(i)==Harfler.charAt(j)) {
									yenikrktler=yenikrktler+String.valueOf(krktler.charAt(i)) ;
								}
							}
							
						}
						txtAdi1.setText(yenikrktler);//Yeni karakterleri txtfielde aktarma
						if (yenikrktler.equals(krktler)) {
						} else {
							lblHata2.setText("*Rakamlar kaldýrýldý");
						}
						txtAdi1.setEditable(true);					
				}
			}
		});
		txtAdi1.setVisible(false);
		txtAdi1.setColumns(10);
		txtAdi1.setBounds(232, 170, 250, 50);
		contentPane.add(txtAdi1);
		
		txtSoyad1 = new JTextField();
		txtSoyad1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtSoyad1.addKeyListener(new KeyAdapter() {//Sadece harf kontrolü yapýlýyor
			public void keyPressed(KeyEvent ke) {
				String Harfler="qwertyuýopðüasdfghjklþizxcvbnmöçQWERTYUIOPÐÜASDFGHJKLÞÝZXCVBNMÖÇ";
				try {
					for (int i = 0; i < Harfler.length(); i++) {//Ctrl+V,X,A,C veya silme tuþu veya space veya harf girildiðinde izin verilme
						if (ke.getKeyChar() == Harfler.charAt(i)||ke.getKeyCode() == KeyEvent.VK_BACK_SPACE||ke.getKeyCode()==KeyEvent.VK_SPACE||ke.getKeyCode()==KeyEvent.VK_CONTROL||((ke.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)&&(ke.getKeyCode() == KeyEvent.VK_C || ke.getKeyCode() ==KeyEvent.VK_V || ke.getKeyCode() ==KeyEvent.VK_X||ke.getKeyCode()==KeyEvent.VK_A)) {            	
							txtSoyad1.setEditable(true);
							lblHata1.setText("");
							break;
			            }
						else {
							txtSoyad1.setEditable(false);
			               lblHata1.setText("*Sadece Harfler(a-Z)");
			            }
					}
				} catch (Exception e) {
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {//Ctrl+V basýldýðýnda kopyalanan karakter kontrolleri
				if (e.getKeyCode() ==KeyEvent.VK_V && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0||e.getKeyCode()==KeyEvent.VK_V) {
						
						String Harfler="qwertyuýopðüasdfghjklþizxcvbnmöçQWERTYUIOPÐÜASDFGHJKLÞÝZXCVBNMÖÇ";
						String krktler=txtSoyad1.getText();
						String yenikrktler="";
						for (int i = 0; i < krktler.length(); i++) {
							for (int j = 0; j < Harfler.length(); j++) {
								if (krktler.charAt(i)==Harfler.charAt(j)) {
									yenikrktler=yenikrktler+String.valueOf(krktler.charAt(i)) ;
								}
							}
							
						}
						txtSoyad1.setText(yenikrktler);//Yeni karakterleri txtfielde aktarma
						if (yenikrktler.equals(krktler)) {
						} else {
							lblHata1.setText("*Rakamlar kaldýrýldý");
						}
						txtSoyad1.setEditable(true);					
				}
			}
		});
		txtSoyad1.setVisible(false);
		txtSoyad1.setColumns(10);
		txtSoyad1.setBounds(232, 230, 250, 50);
		contentPane.add(txtSoyad1);
		
		txtMaas1 = new JTextField();
		txtMaas1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtMaas1.setVisible(false);
		txtMaas1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {//Sadece rakamlar kontrolü
				try {
					if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'||ke.getKeyCode() == KeyEvent.VK_BACK_SPACE||ke.getKeyCode()==KeyEvent.VK_CONTROL||(ke.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0 &&(ke.getKeyCode() == KeyEvent.VK_C||ke.getKeyCode() ==KeyEvent.VK_V||ke.getKeyCode() ==KeyEvent.VK_X||ke.getKeyCode() ==KeyEvent.VK_A)) {            	
						txtMaas1.setEditable(true);
						lblHata.setText("");
						
		            } else {
					   txtMaas1.setEditable(false);
		               lblHata.setText("*Sadece Rakamlar(0-9)");
		            }
				} catch (Exception e) {
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {//Ctrl+V basýldýðýnda kopyalanan karakterler rakam kontrolü
				if (e.getKeyCode() ==KeyEvent.VK_V && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0||e.getKeyCode()==KeyEvent.VK_V) {
					
						String rakamlar="0123456789";
						String krktler=txtMaas1.getText();
						String yenikrktler="";
						for (int i = 0; i < krktler.length(); i++) {
							for (int j = 0; j < rakamlar.length(); j++) {
								if (krktler.charAt(i)==rakamlar.charAt(j)) {
									yenikrktler=yenikrktler+String.valueOf(krktler.charAt(i)) ;
								}
							}
							
						}
						txtMaas1.setText(yenikrktler);//Yeni karakterler txtfield aktarma
						if (yenikrktler.equals(krktler)) {
						} else {
							lblHata.setText("*Harfler kaldýrýldý");
						}
						txtMaas1.setEditable(true);					
				}
			}
		});
		txtMaas1.setColumns(10);
		txtMaas1.setBounds(232, 290, 250, 50);
		contentPane.add(txtMaas1);
		
		JButton btnPersonelEkle = new JButton(" Ekle");
		btnPersonelEkle.setVisible(false);
		btnPersonelEkle.addActionListener(new ActionListener() {//yeni personel ekleme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					java.sql.Statement st= Giris.conn.createStatement();
					if (!txtAdi1.getText().isEmpty()&&!txtSoyad1.getText().isEmpty()) {//alanlar boþ mu kontrolleri
						if (txtMaas1.getText().isEmpty()&&cmbxBolum.getSelectedItem().equals("")) {
							st.execute("insert into Personel(Per_ad,Per_soyad) VALUES ('"+txtAdi1.getText()+"','"+txtSoyad1.getText()+"')");
							JOptionPane.showMessageDialog(null, "Ekleme Baþarýlý");
						} else if (!txtMaas1.getText().isEmpty()&&cmbxBolum.getSelectedItem()!="") {
							st.execute("insert into Personel(Per_ad,Per_soyad,Per_maas,Per_bolum) VALUES ('"+txtAdi1.getText()+"','"+txtSoyad1.getText()+"','"+txtMaas1.getText()+"','"+cmbxBolum.getSelectedItem()+"')");
							JOptionPane.showMessageDialog(null, "Ekleme Baþarýlý");
						} else if(txtMaas1.getText().isEmpty()){
							st.execute("insert into Personel(Per_ad,Per_soyad,Per_bolum) VALUES ('"+txtAdi1.getText()+"','"+txtSoyad1.getText()+"','"+cmbxBolum.getSelectedItem()+"')");
							JOptionPane.showMessageDialog(null, "Ekleme Baþarýlý");
						} else{
							st.execute("insert into Personel(Per_ad,Per_soyad,Per_maas) VALUES ('"+txtAdi1.getText()+"','"+txtSoyad1.getText()+"','"+txtMaas1.getText()+"')");
							JOptionPane.showMessageDialog(null, "Ekleme Baþarýlý");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Adý veya soyadý boþ býrakýlamaz ");
					}
					Giris.conn.close();
					st.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Satýr baþýnda veya sonunda boþluk býrakmayýnýz");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});
		btnPersonelEkle.setIcon(new ImageIcon("icon\\personelekle.png"));
		btnPersonelEkle.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonelEkle.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnPersonelEkle.setBounds(232, 480, 250, 50);
		contentPane.add(btnPersonelEkle);
		
		JButton btnKullaniciEkle = new JButton(" Ekle");
		btnKullaniciEkle.setVisible(false);
		btnKullaniciEkle.addActionListener(new ActionListener() {//Yeni kullanýcý hesabý oluþturma iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st= Giris.conn.createStatement();
					if (cmbxPersonelNo1.getSelectedIndex()>0) {//Per_no alýnmasý ve gerekli alanlarýn boþ mu kontrolü
						if (!txtKullaniciAdi.getText().isEmpty()&&!String.valueOf(txtSifre.getPassword()).isEmpty()) {
							st.execute("insert into KlncHesaplari values ('"+cmbxPersonelNo1.getSelectedItem()+"','"+cmbxYetki.getSelectedItem()+"','"+txtKullaniciAdi.getText()+"','"+String.valueOf(txtSifre.getPassword())+"')");
							txtKullaniciAdi.setText("");
							txtSifre.setText("");		
							cmbxmdlPerBilgi1.removeElement(cmbxPersonelNo1.getSelectedItem());
							cmbxPersonelNo1.setSelectedItem(null);
							JOptionPane.showMessageDialog(null, "Kullanýcý Hesabý Oluþturuldu");
						} else {
							JOptionPane.showMessageDialog(null, "Kullanýcý adý veya þifre boþ olamaz!!!!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Personel no seçiniz..");
					}
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Kullanýcý Adý Kullanýlýyor...");//ayný kullanýcý olma hata 
				}	
			}
		});
		btnKullaniciEkle.setHorizontalAlignment(SwingConstants.LEFT);
		btnKullaniciEkle.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnKullaniciEkle.setBounds(232, 480, 125, 50);
		contentPane.add(btnKullaniciEkle);
		
		JButton btnKullaniciSil = new JButton(" Sil");
		btnKullaniciSil.setVisible(false);
		btnKullaniciSil.addActionListener(new ActionListener() {//Kullanýcý hesabý silme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					java.sql.Statement st= Giris.conn.createStatement();
					int perNo=Integer.parseInt(JOptionPane.showInputDialog("Personel No Giriniz"));//Kullanýcý veri giriþi yapýlýyor ve int türüne dönüþtürülüyor
					ResultSet rs=st.executeQuery("select Per_ad,Per_soyad from Personel where Per_no='"+perNo+"'");				
					if (!rs.isClosed()) {//Personelin bulunma kontrolü
						int a= JOptionPane.showConfirmDialog(null, rs.getString(1)+" "+rs.getString(2)+" Adlý personelin kullanýcý hesabý silinecek emin misiniz??");
						if (a==JOptionPane.YES_OPTION) {//Onaylanma durumunda silme iþlemi
							st.execute("delete from KlncHesaplari where Per_no='"+perNo+"'");
							JOptionPane.showMessageDialog(null,"Baþarýyla silindi");
							cmbxmdlPerBilgi1.addElement(perNo);
						} 
					} else {
						JOptionPane.showMessageDialog(null, "Personel Bulunamadý");
					}
					Giris.conn.close();
					st.close();
					rs.close();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "*Sadece rakamlar(0-9)");
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}	
			}
		});
		btnKullaniciSil.setHorizontalAlignment(SwingConstants.LEFT);
		btnKullaniciSil.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnKullaniciSil.setBounds(357, 480, 125, 50);
		contentPane.add(btnKullaniciSil);
		
		txtMaas2 = new JTextField();
		txtMaas2.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtMaas2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {//Sadece rakamlar kontrolü
				try {
					if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'||ke.getKeyCode() == KeyEvent.VK_BACK_SPACE||ke.getKeyCode()==KeyEvent.VK_CONTROL||(ke.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0 &&(ke.getKeyCode() == KeyEvent.VK_C||ke.getKeyCode() ==KeyEvent.VK_V||ke.getKeyCode() ==KeyEvent.VK_X||ke.getKeyCode() ==KeyEvent.VK_A)) {            	
						txtMaas2.setEditable(true);
						lblHata.setText("");
						
		            } else {
					   txtMaas2.setEditable(false);
		               lblHata.setText("*Sadece Rakamlar(0-9)");
		            }
				} catch (Exception e) {
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {//Ctrl+V basýldýðýnda kopyalanan karakterler rakam kontrolü
				if (e.getKeyCode() ==KeyEvent.VK_V && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0||e.getKeyCode()==KeyEvent.VK_V) {
					
						String rakamlar="0123456789";
						String krktler=txtMaas2.getText();
						String yenikrktler="";
						for (int i = 0; i < krktler.length(); i++) {
							for (int j = 0; j < rakamlar.length(); j++) {
								if (krktler.charAt(i)==rakamlar.charAt(j)) {
									yenikrktler=yenikrktler+String.valueOf(krktler.charAt(i)) ;
								}
							}
							
						}
						txtMaas2.setText(yenikrktler);//Yeni karakterler txtfield aktarma
						if (yenikrktler.equals(krktler)) {
						} else {
							lblHata.setText("*Harfler kaldýrýldý");
						}
						txtMaas2.setEditable(true);					
				}
			}
		});
		txtMaas2.setVisible(false);
		txtMaas2.setColumns(10);
		txtMaas2.setBounds(232, 290, 250, 50);
		contentPane.add(txtMaas2);
		
		JButton btnMaasGuncelle = new JButton(" G\u00FCncelle");
		btnMaasGuncelle.setVisible(false);
		btnMaasGuncelle.addActionListener(new ActionListener() {//Maaþ Güncelleme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					java.sql.Statement st= Giris.conn.createStatement();
					if (cmbxPersonelNo.getSelectedItem()!=null) {//Per_no seçilme kontrolü
						st.execute("UPDATE Personel set Per_maas='"+txtMaas2.getText()+"'  where Per_no='"+cmbxPersonelNo.getSelectedItem()+"'");
						JOptionPane.showMessageDialog(null, cmbxPersonelNo.getSelectedItem()+" Nolu Personelin maaþý güncellendi.");
					} else {
						JOptionPane.showMessageDialog(null, "Personel No Seçiniz...");
					}
					Giris.conn.close();
					st.close();
				} catch (SQLException e1) {
					System.out.println("Sorgu Hatasý...!!!");
					e1.printStackTrace();
				} catch (Exception e2) {
					System.out.println("Veritabanýna baðlanýlamadý");
				}
				
			}
		});
		btnMaasGuncelle.setIcon(new ImageIcon("icon\\mguncelle.png"));
		btnMaasGuncelle.setHorizontalAlignment(SwingConstants.LEFT);
		btnMaasGuncelle.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnMaasGuncelle.setBounds(233, 430, 250, 50);
		contentPane.add(btnMaasGuncelle);
		
		JButton btnSil = new JButton("Personel Sil");
		btnSil.setIcon(new ImageIcon("icon\\personelsill.png"));
		btnSil.setVisible(false);
		btnSil.addActionListener(new ActionListener() {//Personel silme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					java.sql.Statement st= Giris.conn.createStatement();
					if (cmbxPersonelNo.getSelectedItem()!=null) {//Per no seçilme kontrolü
						if (cmbxPersonelNo.getSelectedItem().equals(Giris.per_no)) {// Kendisini silme engelleme kontrolü
							JOptionPane.showMessageDialog(null, "Maalesef kendinizi silemezsiniz :/");
						} else {
							st.execute("PRAGMA foreign_keys=ON");//Sqlite yabancý anahtar desteðini aktif hale getirme
							st.execute("delete from personel where Per_no='"+cmbxPersonelNo.getSelectedItem()+"'");
							JOptionPane.showMessageDialog(null, cmbxPersonelNo.getSelectedItem()+" Nolu Personel Silindi");
							cmbxPersonelNo.removeItem(cmbxPersonelNo.getSelectedItem());
						}	
					} else {
						JOptionPane.showMessageDialog(null, "Personel No Seçiniz...");
					}
					Giris.conn.close();
					st.close();
				} catch (SQLException e1) {
					System.out.println("Sorgu Hatasý...!!!");
					e1.printStackTrace();
				} catch (Exception e2) {
					System.out.println("Veritabanýna baðlanýlamadý");
				}
				
			}
		});
		btnSil.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		btnSil.setBounds(233, 475, 250, 50);
		contentPane.add(btnSil);
		
		txtSoyad2 = new JTextField();
		txtSoyad2.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtSoyad2.setDisabledTextColor(Color.black);
		txtSoyad2.setEnabled(false);
		txtSoyad2.setVisible(false);
		txtSoyad2.setColumns(10);
		txtSoyad2.setBounds(232, 230, 250, 50);
		contentPane.add(txtSoyad2);
		
		txtSoyad3 = new JTextField();
		txtSoyad3.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtSoyad3.setDisabledTextColor(Color.black);
		txtSoyad3.setEnabled(false);
		txtSoyad3.setVisible(false);
		txtSoyad3.setColumns(10);
		txtSoyad3.setBounds(232, 230, 250, 50);
		contentPane.add(txtSoyad3);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtKullaniciAdi.setVisible(false);
		txtKullaniciAdi.setColumns(10);
		txtKullaniciAdi.setBounds(232, 290, 250, 50);
		contentPane.add(txtKullaniciAdi);
		
		txtSifre = new JPasswordField();
		txtSifre.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtSifre.setVisible(false);
		txtSifre.setColumns(10);
		txtSifre.setBounds(232, 350, 250, 50);
		contentPane.add(txtSifre);
		
		txtAdi2 = new JTextField();
		txtAdi2.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtAdi2.setDisabledTextColor(Color.black);
		txtAdi2.setEnabled(false);
		txtAdi2.setVisible(false);
		txtAdi2.setColumns(10);
		txtAdi2.setBounds(232, 170, 250, 50);
		contentPane.add(txtAdi2);
		
		txtAdi3 = new JTextField();
		txtAdi3.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		txtAdi3.setDisabledTextColor(Color.black);
		txtAdi3.setEnabled(false);
		txtAdi3.setVisible(false);
		txtAdi3.setColumns(10);
		txtAdi3.setBounds(232, 170, 250, 50);
		contentPane.add(txtAdi3);
		
		JLabel lblAdi2 = new JLabel("Ad\u0131n\u0131z:");
		lblAdi2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi2.setVisible(false);
		lblAdi2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdi2.setBounds(0, 72, 177, 50);
		contentPane.add(lblAdi2);
		
		JLabel lblSoyadi2 = new JLabel("Soyad\u0131n\u0131z:");
		lblSoyadi2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi2.setVisible(false);
		lblSoyadi2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyadi2.setBounds(0, 133, 177, 50);
		contentPane.add(lblSoyadi2);
		
		JLabel lblMaas2 = new JLabel("Maaþýnýz:");
		lblMaas2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas2.setVisible(false);
		lblMaas2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaas2.setBounds(0, 255, 177, 50);
		contentPane.add(lblMaas2);
		
		JLabel lblAdi3 = new JLabel("");
		lblAdi3.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi3.setVisible(false);
		lblAdi3.setForeground(new Color(255, 0, 0));
		lblAdi3.setBounds(179, 72, 250, 50);
		contentPane.add(lblAdi3);
		
		JLabel lblSoyadi3 = new JLabel("");
		lblSoyadi3.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi3.setVisible(false);
		lblSoyadi3.setForeground(new Color(255, 0, 0));
		lblSoyadi3.setBounds(179, 133, 250, 50);
		contentPane.add(lblSoyadi3);
		
		JLabel lblMaas3 = new JLabel("");
		lblMaas3.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas3.setVisible(false);
		lblMaas3.setForeground(new Color(255, 0, 0));
		lblMaas3.setBounds(179, 255, 250, 50);
		contentPane.add(lblMaas3);
	
		JLabel lblHosÝcon = new JLabel("");
		lblHosÝcon.setIcon(new ImageIcon("icon\\mudur.png"));
		lblHosÝcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHosÝcon.setBounds(664, 11, 110, 66);
		contentPane.add(lblHosÝcon);
		
		cmbxPersonelNo = new JComboBox<Integer>();
		cmbxPersonelNo.addActionListener(new ActionListener() {//Personel listeleme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					if (cmbxPersonelNo.getSelectedIndex()>-1) {//Varsayýlan indexin seçili olma kontrolü
						ResultSet rs=st.executeQuery("select Per_ad,Per_soyad,Per_bolum,Per_maas from Personel where Per_no='"+cmbxPersonelNo.getSelectedItem()+"'");
						txtAdi.setText(rs.getString(1));
						txtSoyad.setText(rs.getString(2));
						txtBolum.setText(rs.getString(3));
						txtMaas.setText(rs.getString(4));
						txtAdi2.setText(rs.getString(1));
						txtSoyad2.setText(rs.getString(2));
						txtMaas2.setText(rs.getString(4));
						Giris.conn.close();
						rs.close();
						st.close();
					} else {// Varsayýlan hale getirme
						txtAdi.setText("");
						txtSoyad.setText("");
						txtBolum.setText("");
						txtMaas.setText("");
						txtAdi2.setText("");
						txtSoyad2.setText("");
						txtMaas2.setText("");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Personel Bilgisini Alýnamadý");
				}
			}
		});
		cmbxPersonelNo.setMaximumRowCount(6);
		cmbxPersonelNo.setVisible(false);
		cmbxmdlPerBilgi=(DefaultComboBoxModel<Integer>) cmbxPersonelNo.getModel();
		cmbxPersonelNo.setBounds(233, 72, 250, 50);
		contentPane.add(cmbxPersonelNo);
		
		cmbxPersonelNo1 = new JComboBox<Integer>();
		cmbxPersonelNo1.addActionListener(new ActionListener() {//Personel listeleme iþlemleri (Kullanýcý)
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					if (cmbxPersonelNo1.getSelectedIndex()>-1) {//Varsayýlan indexin seçili olma kontrolü
						ResultSet rs=st.executeQuery("Select Per_ad,Per_soyad from Personel where Per_no='"+cmbxPersonelNo1.getSelectedItem()+"'");
						txtAdi3.setText(rs.getString(1));
						txtSoyad3.setText(rs.getString(2));
						
						Giris.conn.close();
						st.close();
						rs.close();
						
					} else {
						txtAdi3.setText("");
						txtSoyad3.setText("");
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"");
				}
			}
		});
		cmbxPersonelNo1.setMaximumRowCount(5);
		cmbxPersonelNo1.setVisible(false);
		cmbxmdlPerBilgi1=(DefaultComboBoxModel<Integer>) cmbxPersonelNo1.getModel();
		cmbxPersonelNo1.setBounds(233, 72, 250, 50);
		contentPane.add(cmbxPersonelNo1);
		
		cmbxBolum = new JComboBox<String>();
		cmbxBolum.setMaximumRowCount(4);
		cmbxBolum.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Depo", "Temizlik", "\u00DCretim", "Teknik"}));
		cmbxBolum.setVisible(false);
		cmbxBolum.setBounds(233, 350, 250, 50);
		contentPane.add(cmbxBolum);
		
		JButton btnYeniKullanici = new JButton(" Yeni Kullan\u0131c\u0131");
		btnYeniKullanici.setIcon(new ImageIcon("icon\\yeniKullanici.png"));
		btnYeniKullanici.setHorizontalAlignment(SwingConstants.LEFT);
		btnYeniKullanici.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnYeniKullanici.setBounds(10, 333, 421, 95);
		contentPane.add(btnYeniKullanici);
		
		cmbxYetki = new JComboBox<String>();
		cmbxYetki.setMaximumRowCount(4);
		cmbxYetki.setModel(new DefaultComboBoxModel<String>(new String[] {"Personel", "Usta", "M\u00FCd\u00FCr Yard\u0131mc\u0131s\u0131", "M\u00FCd\u00FCr"}));
		cmbxYetki.setVisible(false);
		cmbxYetki.setBounds(232, 410, 250, 50);
		contentPane.add(cmbxYetki);
		
		lblhosgeldin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//Kullanýcý adý üstüne gelme iþlemleri
				Color c=lblhosgeldin.getBackground();//ters renklendirme
				lblhosgeldin.setBackground(lblhosgeldin.getForeground());
				lblhosgeldin.setForeground(c);
			}
			public void mouseExited(MouseEvent e) {//Kullanýcý adý üstünden ayrýlma iþlemleri
				Color c=lblhosgeldin.getForeground();//ters renklendirme
				lblhosgeldin.setForeground(lblhosgeldin.getBackground());
				lblhosgeldin.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {//Kullanýcý adý týklama iþlemleri
				btnyenipersonel.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnmaasduzenle.setVisible(false);
				btnYeniKullanici.setVisible(false);
				btnMaasGuncelle.setVisible(false);
				btnPersonelEkle.setVisible(false);
				btnSil.setVisible(false);
				lblAdi1.setVisible(false);
				lblSoyad1.setVisible(false);
				lblMaas1.setVisible(false);
				lblPersonelNo.setVisible(false);
				lblAdi.setVisible(false);
				lblSoyad1.setVisible(false);
				lblSoyad.setVisible(false);
				lblMaas.setVisible(false);
				lblBolum.setVisible(false);
				lblHata.setVisible(false);
				lblHata.setText("");
				lblHata1.setVisible(false);
				lblHata1.setText("");
				lblHata2.setVisible(false);
				lblHata2.setText("");
				txtAdi1.setVisible(false);
				txtSoyad1.setVisible(false);
				txtMaas1.setVisible(false);
				txtAdi2.setVisible(false);
				txtMaas2.setVisible(false);
				txtSoyad2.setVisible(false);
				txtBolum.setVisible(false);
				txtAdi.setVisible(false);
				txtSoyad.setVisible(false);
				txtMaas.setVisible(false);
				btnGeri.setVisible(true);
				lblAdi2.setVisible(true);
				lblAdi3.setVisible(true);
				lblSoyadi2.setVisible(true);
				lblSoyadi3.setVisible(true);
				lblMaas2.setVisible(true);
				lblMaas3.setVisible(true);
				cmbxPersonelNo.setVisible(false);
				cmbxPersonelNo1.setVisible(false);
				lblBolum1.setVisible(false);
				cmbxBolum.setVisible(false);
				lblAdi1.setVisible(false);
				lblSoyad1.setVisible(false);
				lblKullaniciAdi.setVisible(false);
				lblSifre.setVisible(false);
				lblYetki.setVisible(false);
				txtAdi3.setVisible(false);
				txtSoyad3.setVisible(false);
				txtKullaniciAdi.setVisible(false);
				txtSifre.setVisible(false);
				cmbxYetki.setVisible(false);
				btnKullaniciSil.setVisible(false);
				btnKullaniciEkle.setVisible(false);
				if (cmbxPersonelNo.getSelectedIndex()>0) {
					seciliP=(Integer) cmbxPersonelNo.getSelectedItem();
				} else {

				}
				cmbxmdlPerBilgi.removeAllElements();
				cmbxmdlPerBilgi1.removeAllElements();
				try {//giris yapýlan personel bilgileri listeleme iþlemleri
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_ad,Per_soyad,Per_maas from Personel where Per_no='"+Giris.per_no+"'");
					lblAdi3.setText(rs.getString(1));
					lblSoyadi3.setText(rs.getString(2));
					lblMaas3.setText(rs.getString(3));
					rs.close();
					Giris.conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnpersonelbilgileri.addActionListener(new ActionListener() {//Personel bilgileri ekraný iþlemler 
			public void actionPerformed(ActionEvent e) {
				btnpersonelbilgileri.setVisible(false);
				btnyenipersonel.setVisible(false);
				btnmaasduzenle.setVisible(false);
				btnYeniKullanici.setVisible(false);
				btnGeri.setVisible(true);
				btnSil.setVisible(true);
				lblPersonelNo.setVisible(true);
				lblAdi.setVisible(true);
				lblSoyad.setVisible(true);
				lblMaas.setVisible(true);
				lblBolum.setVisible(true);
				txtBolum.setVisible(true);
				txtAdi.setVisible(true);
				txtSoyad.setVisible(true);
				txtMaas.setVisible(true);
				cmbxPersonelNo.setVisible(true);
				cmbxmdlPerBilgi.removeAllElements();
				try {//Bütün Personellerin bilgilerini alma iþlemleri
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_no from Personel");
					cmbxmdlPerBilgi.addElement(null);
					while (rs.next()) {
						cmbxmdlPerBilgi.addElement(rs.getInt(1));
					}
					rs.close();
					Giris.conn.close();
					st.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var");
				}
				cmbxmdlPerBilgi.setSelectedItem(seciliP);//Daha önce seçili olan personelin verisini getirme
			}
		});
		btnyenipersonel.addActionListener(new ActionListener() {//Yeni personel ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnpersonelbilgileri.setVisible(false);
				btnyenipersonel.setVisible(false);
				btnmaasduzenle.setVisible(false);
				btnYeniKullanici.setVisible(false);
				btnGeri.setVisible(true);
				btnPersonelEkle.setVisible(true);
				lblAdi1.setVisible(true);
				lblSoyad1.setVisible(true);
				lblMaas1.setVisible(true);
				lblBolum1.setVisible(true);
				lblHata.setVisible(true);
				lblHata1.setVisible(true);
				lblHata2.setVisible(true);
				txtAdi1.setVisible(true);
				txtSoyad1.setVisible(true);
				txtMaas1.setVisible(true);
				cmbxBolum.setVisible(true);
			}
		});
		
		btnmaasduzenle.addActionListener(new ActionListener() {//Maas düzenle ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnmaasduzenle.setVisible(false);
				btnyenipersonel.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnYeniKullanici.setVisible(false);
				btnGeri.setVisible(true);
				btnMaasGuncelle.setVisible(true);
				lblMaas1.setVisible(true);
				lblPersonelNo.setVisible(true);
				lblAdi1.setVisible(true);
				lblSoyad1.setVisible(true);
				lblHata.setVisible(true);
				txtAdi2.setVisible(true);
				txtMaas2.setVisible(true);
				txtSoyad2.setVisible(true);
				cmbxPersonelNo.setVisible(true);
				cmbxmdlPerBilgi.removeAllElements();
				try {//Bütün personelerin bilgileri alma
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_no from Personel");
					cmbxmdlPerBilgi.addElement(null);
					while (rs.next()) {
						cmbxmdlPerBilgi.addElement(rs.getInt(1));
					}
					rs.close();
					Giris.conn.close();
					st.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var");
				}
				
				cmbxmdlPerBilgi.setSelectedItem(seciliP);
			}
		});
		
		btnYeniKullanici.addActionListener(new ActionListener() {//Yeni kullanýcý ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnpersonelbilgileri.setVisible(false);
				btnyenipersonel.setVisible(false);
				btnmaasduzenle.setVisible(false);
				btnYeniKullanici.setVisible(false);
				btnGeri.setVisible(true);
				lblPersonelNo.setVisible(true);
				cmbxPersonelNo1.setVisible(true);
				lblAdi1.setVisible(true);
				lblSoyad1.setVisible(true);
				lblKullaniciAdi.setVisible(true);
				lblSifre.setVisible(true);
				lblYetki.setVisible(true);
				txtAdi3.setVisible(true);
				txtSoyad3.setVisible(true);
				txtKullaniciAdi.setVisible(true);
				txtSifre.setVisible(true);
				cmbxYetki.setVisible(true);
				btnKullaniciSil.setVisible(true);
				btnKullaniciEkle.setVisible(true);
				cmbxmdlPerBilgi1.removeAllElements();
				try {//Kullanýcý hesabý olmayan personelleri listeleme iþlemleri
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_no from Personel p where not exists (select Per_no from KlncHesaplari klnc where p.Per_no = klnc.Per_no)");
					cmbxmdlPerBilgi1.addElement(null);
					if (rs.isClosed()) {
						JOptionPane.showMessageDialog(null, "Yeni Kullanýcý hesabý oluþturulamaz..");
					} else {
						while (rs.next()) {
							cmbxmdlPerBilgi1.addElement(rs.getInt(1));
						}
					}
					Giris.conn.close();
					st.close();
					rs.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});
		
		btnGeri.addActionListener(new ActionListener() {//AnaEkran
			public void actionPerformed(ActionEvent e) {
				btnpersonelbilgileri.setVisible(true);
				btnyenipersonel.setVisible(true);
				btnmaasduzenle.setVisible(true);
				btnYeniKullanici.setVisible(true);
				btnGeri.setVisible(false);
				btnMaasGuncelle.setVisible(false);
				btnPersonelEkle.setVisible(false);
				btnSil.setVisible(false);
				lblAdi1.setVisible(false);
				lblSoyad1.setVisible(false);
				lblMaas1.setVisible(false);
				lblPersonelNo.setVisible(false);
				lblAdi.setVisible(false);
				lblSoyad1.setVisible(false);
				lblSoyad.setVisible(false);
				lblMaas.setVisible(false);
				lblBolum.setVisible(false);
				lblHata.setVisible(false);
				lblHata.setText("");
				lblHata1.setVisible(false);
				lblHata1.setText("");
				lblHata2.setVisible(false);
				lblHata2.setText("");
				lblAdi2.setVisible(false);
				lblAdi3.setVisible(false);
				lblAdi3.setText("");
				lblSoyadi2.setVisible(false);
				lblSoyadi3.setVisible(false);
				lblSoyadi3.setText("");
				lblMaas2.setVisible(false);
				lblMaas3.setVisible(false);
				lblMaas3.setText("");
				txtAdi1.setVisible(false);
				txtSoyad1.setVisible(false);
				txtMaas1.setVisible(false);
				txtAdi2.setVisible(false);
				txtMaas2.setVisible(false);
				txtSoyad2.setVisible(false);
				txtBolum.setVisible(false);
				txtAdi.setVisible(false);
				txtSoyad.setVisible(false);
				txtMaas.setVisible(false);
				cmbxPersonelNo.setVisible(false);	
				cmbxPersonelNo1.setVisible(false);
				lblBolum1.setVisible(false);
				cmbxBolum.setVisible(false);
				lblAdi1.setVisible(false);
				lblSoyad1.setVisible(false);
				lblKullaniciAdi.setVisible(false);
				lblSifre.setVisible(false);
				lblYetki.setVisible(false);
				txtAdi3.setVisible(false);
				txtSoyad3.setVisible(false);
				txtKullaniciAdi.setVisible(false);
				txtSifre.setVisible(false);
				cmbxYetki.setVisible(false);
				btnKullaniciSil.setVisible(false);
				btnKullaniciEkle.setVisible(false);
				if (cmbxPersonelNo.getSelectedIndex()>0) {//Daha önce seçili personeli saklama
					seciliP=(Integer) cmbxPersonelNo.getSelectedItem();
				} else {

				}
				cmbxmdlPerBilgi.removeAllElements();
				cmbxmdlPerBilgi1.removeAllElements();
				
			}
		});
	}
}
