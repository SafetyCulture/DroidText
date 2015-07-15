package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;

import java.security.SecureRandom;

interface TlsSigner
{
	byte[] calculateRawSignature(SecureRandom random, AsymmetricKeyParameter privateKey, byte[] md5andsha1)
			throws CryptoException;

	Signer createVerifyer(AsymmetricKeyParameter publicKey);

	boolean isValidPublicKey(AsymmetricKeyParameter publicKey);
}
