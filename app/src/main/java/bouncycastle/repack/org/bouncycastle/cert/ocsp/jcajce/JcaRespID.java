package repack.org.bouncycastle.cert.ocsp.jcajce;

import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.cert.ocsp.OCSPException;
import repack.org.bouncycastle.cert.ocsp.RespID;
import repack.org.bouncycastle.operator.DigestCalculator;

import javax.security.auth.x500.X500Principal;
import java.security.PublicKey;

public class JcaRespID
		extends RespID
{
	public JcaRespID(X500Principal name)
	{
		super(X500Name.getInstance(name.getEncoded()));
	}

	public JcaRespID(PublicKey pubKey, DigestCalculator digCalc)
			throws OCSPException
	{
		super(SubjectPublicKeyInfo.getInstance(pubKey.getEncoded()), digCalc);
	}
}
