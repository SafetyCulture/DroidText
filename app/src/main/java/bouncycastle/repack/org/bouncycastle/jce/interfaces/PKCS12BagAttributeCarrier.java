package repack.org.bouncycastle.jce.interfaces;

import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;

import java.util.Enumeration;

/**
 * allow us to set attributes on objects that can go into a PKCS12 store.
 */
public interface PKCS12BagAttributeCarrier
{
	void setBagAttribute(
			DERObjectIdentifier oid,
			DEREncodable attribute);

	DEREncodable getBagAttribute(
			DERObjectIdentifier oid);

	Enumeration getBagAttributeKeys();
}
