package repack.org.bouncycastle.pkcs;

import repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;

import java.io.IOException;

/**
 * Holding class for a PKCS#8 EncryptedPrivateKeyInfo structure.
 */
public class EncryptedPrivateKeyInfoHolder
{
	private EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;

	public EncryptedPrivateKeyInfoHolder(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo)
	{
		this.encryptedPrivateKeyInfo = encryptedPrivateKeyInfo;
	}

	public EncryptedPrivateKeyInfo toASN1Structure()
	{
		return encryptedPrivateKeyInfo;
	}

	public byte[] getEncoded()
			throws IOException
	{
		return encryptedPrivateKeyInfo.getEncoded();
	}
}
