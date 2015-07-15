package repack.org.bouncycastle.cert.ocsp.jcajce;

import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.cert.ocsp.BasicOCSPRespBuilder;
import repack.org.bouncycastle.cert.ocsp.OCSPException;
import repack.org.bouncycastle.operator.DigestCalculator;

import java.security.PublicKey;

public class JcaBasicOCSPRespBuilder
		extends BasicOCSPRespBuilder
{
	public JcaBasicOCSPRespBuilder(PublicKey key, DigestCalculator digCalc)
			throws OCSPException
	{
		super(SubjectPublicKeyInfo.getInstance(key.getEncoded()), digCalc);
	}
}
