package repack.org.bouncycastle.cert.ocsp;

import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.ocsp.ResponderID;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.operator.DigestCalculator;

import java.io.OutputStream;

/**
 * Carrier for a ResponderID.
 */
public class RespID
{
	public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);

	ResponderID id;

	public RespID(
			ResponderID id)
	{
		this.id = id;
	}

	public RespID(
			X500Name name)
	{
		this.id = new ResponderID(name);
	}

	/**
	 * Calculate a RespID based on the public key of the responder.
	 *
	 * @param subjectPublicKeyInfo the info structure for the responder public key.
	 * @param digCalc              a SHA-1 digest calculator.
	 * @throws OCSPException on exception creating ID.
	 */
	public RespID(
			SubjectPublicKeyInfo subjectPublicKeyInfo,
			DigestCalculator digCalc)
			throws OCSPException
	{
		try
		{
			if(!digCalc.getAlgorithmIdentifier().equals(HASH_SHA1))
			{
				throw new IllegalArgumentException("only SHA-1 can be used with RespID");
			}

			OutputStream digOut = digCalc.getOutputStream();

			digOut.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
			digOut.close();

			this.id = new ResponderID(new DEROctetString(digCalc.getDigest()));
		}
		catch(Exception e)
		{
			throw new OCSPException("problem creating ID: " + e, e);
		}
	}

	public ResponderID toASN1Object()
	{
		return id;
	}

	public boolean equals(
			Object o)
	{
		if(!(o instanceof RespID))
		{
			return false;
		}

		RespID obj = (RespID) o;

		return id.equals(obj.id);
	}

	public int hashCode()
	{
		return id.hashCode();
	}
}
