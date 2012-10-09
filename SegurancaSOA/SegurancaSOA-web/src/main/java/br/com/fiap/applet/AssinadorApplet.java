package br.com.fiap.applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AssinadorApplet extends JApplet implements ActionListener {
	JButton btAbrir, btSalvar, btAssinar;
	JTextArea log;
	JFileChooser fc;
	File file;
	String chavePrivada;

	public void init() {
		try {
			java.awt.EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					initComponents();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void initComponents() {
		this.setSize(100,100);
		fc = new JFileChooser();
		
		btAbrir = new JButton("Localizar arquivo");		
		btAbrir.addActionListener(this);

		btAssinar = new JButton("Assinar Arquivo");
		btAssinar.addActionListener(this);

		btSalvar = new JButton("Upload Arquivo");
		btSalvar.addActionListener(this);
		
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.add(btAbrir,BorderLayout.PAGE_START);
		buttonPanel.add(btAssinar,BorderLayout.CENTER);
		buttonPanel.add(btSalvar,BorderLayout.SOUTH);

		// Add the buttons and the log to this panel.
		add(buttonPanel, BorderLayout.CENTER);
		// add(logScrollPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Handle open button action.
		if (e.getSource() == btAbrir) {
			int returnVal = fc.showOpenDialog(AssinadorApplet.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();				
			} else {
				
			}
			
			
		} else if (e.getSource() == btAssinar) {
			int returnVal = fc.showSaveDialog(AssinadorApplet.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file2 = fc.getSelectedFile();
				System.out.println(file.getAbsolutePath());
				String conteudo=loadArquivo(file);
				Seguranca seguranca= new Seguranca();
				String hashMD5=seguranca.gerarMD5(conteudo);
				this.chavePrivada=seguranca.getChavePrivada();
				String criptografia =seguranca.criptografar(this.chavePrivada, hashMD5);
				salvarArquivo(file2, conteudo+"#####ASSINATURA####"+criptografia+"#####ASSINATURAFIM####");
			} else {			
			}
			
		}else if (e.getSource() == btSalvar) {
			int returnVal = fc.showOpenDialog(AssinadorApplet.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				String conteudo=loadArquivo(file);
			} else {
			}
			
		}
	}
	
	public String loadArquivo(File file){			
		try {
			FileInputStream fis;			
			fis = new FileInputStream(file);
			byte[] conteudo = new byte[(int) file.length()];
			fis.read(conteudo);
			fis.close();
			return new String(conteudo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	
	public void salvarArquivo(File caminho, String conteudo){	
		try {
			FileOutputStream fos = new FileOutputStream(caminho);
			fos.write(conteudo.getBytes());
			fos.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	public void setChavePrivada(String chavePrivada){
		
	}
}
