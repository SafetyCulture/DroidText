package repack.org.bouncycastle.cert.ocsp;

import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.cert.X509CertificateHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class OCSPUtils
{
	static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];

	static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
	static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());

	static Date extractDate(DERGeneralizedTime time)
	{
		try
		{
			return time.getDate();
		}
		catch(Exception e)
		{
			throw new IllegalStateException("exception processing GeneralizedTime: " + e.getMessage());
		}
	}

	static Set getCriticalExtensionOIDs(X509Extensions extensions)
	{
		if(extensions == null)
		{
			return EMPTY_SET;
		}

		return Collections.unmodifiableSet(new HashSet(Arrays.asList(extensions.getCriticalExtensionOIDs())));
	}

	static Set getNonCriticalExtensionOIDs(X509Extensions extensions)
	{
		if(extensions == null)
		{
			return EMPTY_SET;
		}

		// TODO: should probably produce a set that imposes correct ordering
		return Collections.unmodifiableSet(new HashSet(Arrays.asList(extensions.getNonCriticalExtensionOIDs())));
	}

	static List getExtensionOIDs(X509Extensions extensions)
	{
		if(extensions == null)
		{
			return EMPTY_LIST;
		}

		return Collections.unmodifiableList(Arrays.asList(extensions.getExtensionOIDs()));
	}
}
