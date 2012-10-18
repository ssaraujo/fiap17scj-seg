package main.java.br.com.fiap.segurancaSoa.util;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.xml.bind.DatatypeConverter;

public class Seguranca {

	KeyPair keyPair = null;
	String algorithm = "DSA";

	public Seguranca() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
			keyGen.initialize(1024);
			keyPair = keyGen.genKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String getChavePublica() {
		PublicKey publicKey = keyPair.getPublic();
		return new String(DatatypeConverter.printBase64Binary(publicKey
				.getEncoded()));
	}

	public String getChavePrivada() {
		PrivateKey privateKey = keyPair.getPrivate();
		System.out.println(privateKey.getEncoded());
		return new String(DatatypeConverter.printBase64Binary(privateKey
				.getEncoded()));
	}

	public String assinarHash(String chave, String hash) {
		KeyFactory keyFactory;
		try {
			keyFactory = KeyFactory.getInstance(algorithm);
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					DatatypeConverter.parseBase64Binary(chave));
			PrivateKey privateKey = keyFactory
					.generatePrivate(pkcs8EncodedKeySpec);

			byte[] ba = hash.getBytes("UTF8");
			Signature sig = Signature.getInstance(algorithm);
			sig.initSign(privateKey);
			sig.update(ba);
			byte[] signedData = sig.sign();
			// return new String(signedData);
			return DatatypeConverter.printBase64Binary(signedData);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public boolean verificarAssinatura(String chave, String hash, String hashAssinado) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
					DatatypeConverter.parseBase64Binary(chave));
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			byte[] ba = hash.getBytes("UTF8");
			Signature sig = Signature.getInstance(algorithm);
			sig.initVerify(publicKey);
			sig.update(ba);
			return sig.verify(DatatypeConverter.parseBase64Binary(hashAssinado));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
