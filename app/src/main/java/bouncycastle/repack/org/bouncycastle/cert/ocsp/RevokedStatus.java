package repack.org.bouncycastle.cert.ocsp;

import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.ocsp.RevokedInfo;
import repack.org.bouncycastle.asn1.x509.CRLReason;

import java.util.Date;

/**
 * wrapper for the RevokedInfo object
 */
public class RevokedStatus
		implements CertificateStatus
{
	RevokedInfo info;

	public RevokedStatus(
			RevokedInfo info)
	{
		this.info = info;
	}

	public RevokedStatus(
			Date revocationDate,
			int reason)
	{
		this.info = new RevokedInfo(new DERGeneralizedTime(revocationDate), new CRLReason(reason));
	}

	public Date getRevocationTime()
	{
		return OCSPUtils.extractDate(info.getRevocationTime());
	}

	public boolean hasRevocationReason()
	{
		return (info.getRevocationReason() != null);
	}

	/**
	 * return the revocation reason. Note: this field is optional, test for it
	 * with hasRevocationReason() first.
	 *
	 * @return the revocation reason value.
	 * @throws IllegalStateException if a reason is asked for and none is avaliable
	 */
	public int getRevocationReason()
	{
		if(info.getRevocationReason() == null)
		{
			throw new IllegalStateException("attempt to get a reason where none is available");
		}

		return info.getRevocationReason().getValue().intValue();
	}
}
