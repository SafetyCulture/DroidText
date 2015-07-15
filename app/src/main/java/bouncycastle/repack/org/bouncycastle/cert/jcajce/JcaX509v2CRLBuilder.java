package repack.org.bouncycastle.cert.jcajce;

import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.cert.X509v2CRLBuilder;

import javax.security.auth.x500.X500Principal;
import java.util.Date;

public class JcaX509v2CRLBuilder
		extends X509v2CRLBuilder
{
	public JcaX509v2CRLBuilder(X500Principal issuer, Date now)
	{
		super(X500Name.getInstance(issuer.getEncoded()), now);
	}
}
