package repack.org.bouncycastle.cms.jcajce;

import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.cms.KeyTransRecipientId;

import javax.security.auth.x500.X500Principal;
import java.math.BigInteger;
import java.security.cert.X509Certificate;

public class JceKeyTransRecipientId
		extends KeyTransRecipientId
{
	public JceKeyTransRecipientId(X509Certificate certificate)
	{
		this(certificate.getIssuerX500Principal(), certificate.getSerialNumber());
	}

	public JceKeyTransRecipientId(X500Principal issuer, BigInteger serialNumber)
	{
		super(X500Name.getInstance(issuer.getEncoded()), serialNumber);
	}
}
