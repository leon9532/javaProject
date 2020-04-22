package data;



import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Ex_save {
	Ex_Class ex = new Ex_Class();

	ObjectOutputStream oos = null;
	FileOutputStream fos = null;

	// 저장
		public void classSave(Ex_Class exe) {

			Frame f = new Frame();
			f.setBounds(300, 300, 500, 500);
			f.setVisible(true);

			Button btnSave = new Button();
			btnSave.setVisible(true);
			f.add(btnSave);

			//상단 종료 버튼
			f.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}

			});

			//저장 이벤트
			btnSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					ex.setName("저장좀");
					String message = ex.getName();

					System.out.println(message);

					try {

						FileDialog fd = new FileDialog(f, "저장하기", FileDialog.SAVE);
						fd.setVisible(true);

						String path = fd.getDirectory() + fd.getFile();
						System.out.println(path);

						if (!message.equals("")) {
							fos = new FileOutputStream(path);
							oos = new ObjectOutputStream(fos);

							oos.writeObject(exe);

							// FileDialog에서 취소버튼을 누르지 않고 정상적으로 저장한 겨우
							if (fd.getFile() != null) {
								JOptionPane.showMessageDialog(f, "저장완료");
							}

						} else {
							JOptionPane.showMessageDialog(f, "저장할 내용이 없음");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
						// TODO: handle exception
					} finally {
						try {
							oos.close();
							fos.close();
						} catch (Exception e3) {
							// TODO: handle exception
						}
					}

				}
			});

		}

//			String path = "C:\\\\Ex_save/" + e.getName() + "/save.txt";
//			File dir = new File("C:\\\\Ex_save/" + e.getName());
		//
//			if (!dir.exists()) {
//				dir.mkdirs();
//			}
		//
//			try {
//				fos = new FileOutputStream(path);
//				oos = new ObjectOutputStream(fos);
		//
//				oos.writeObject(e);
//				System.out.println("저장");
		//
//			} catch (Exception e2) {
//				// TODO: handle exception
//			} finally {
//				try {
//					oos.close();
//					fos.close();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
		//
//			}

}
