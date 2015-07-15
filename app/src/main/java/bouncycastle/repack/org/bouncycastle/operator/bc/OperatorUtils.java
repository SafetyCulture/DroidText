package repack.org.bouncycastle.operator.bc;

import repack.org.bouncycastle.operator.GenericKey;

import java.security.Key;

class OperatorUtils
{
	static byte[] getKeyBytes(GenericKey key)
	{
		if(key.getRepresentation() instanceof Key)
		{
			return ((Key) key.getRepresentation()).getEncoded();
		}

		if(key.getRepresentation() instanceof byte[])
		{
			return (byte[]) key.getRepresentation();
		}

		throw new IllegalArgumentException("unknown generic key type");
	}
}