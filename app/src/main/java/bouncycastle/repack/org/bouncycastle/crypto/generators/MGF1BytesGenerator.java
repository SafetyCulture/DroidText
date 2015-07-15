package repack.org.bouncycastle.crypto.generators;

import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.DerivationFunction;
import repack.org.bouncycastle.crypto.DerivationParameters;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.params.MGFParameters;

/**
 * Generator for MGF1 as defined in PKCS 1v2
 */
public class MGF1BytesGenerator
		implements DerivationFunction
{
	private Digest digest;
	private byte[] seed;
	private int hLen;

	/**
	 * @param digest the digest to be used as the source of generated bytes
	 */
	public MGF1BytesGenerator(
			Digest digest)
	{
		this.digest = digest;
		this.hLen = digest.getDigestSize();
	}

	public void init(
			DerivationParameters param)
	{
		if(!(param instanceof MGFParameters))
		{
			throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
		}

		MGFParameters p = (MGFParameters) param;

		seed = p.getSeed();
	}

	/**
	 * return the underlying digest.
	 */
	public Digest getDigest()
	{
		return digest;
	}

	/**
	 * int to octet string.
	 */
	private void ItoOSP(
			int i,
			byte[] sp)
	{
		sp[0] = (byte) (i >>> 24);
		sp[1] = (byte) (i >>> 16);
		sp[2] = (byte) (i >>> 8);
		sp[3] = (byte) (i >>> 0);
	}

	/**
	 * fill len bytes of the output buffer with bytes generated from
	 * the derivation function.
	 *
	 * @throws DataLengthException if the out buffer is too small.
	 */
	public int generateBytes(
			byte[] out,
			int outOff,
			int len)
			throws DataLengthException, IllegalArgumentException
	{
		if((out.length - len) < outOff)
		{
			throw new DataLengthException("output buffer too small");
		}

		byte[] hashBuf = new byte[hLen];
		byte[] C = new byte[4];
		int counter = 0;

		digest.reset();

		if(len > hLen)
		{
			do
			{
				ItoOSP(counter, C);

				digest.update(seed, 0, seed.length);
				digest.update(C, 0, C.length);
				digest.doFinal(hashBuf, 0);

				System.arraycopy(hashBuf, 0, out, outOff + counter * hLen, hLen);
			}
			while(++counter < (len / hLen));
		}

		if((counter * hLen) < len)
		{
			ItoOSP(counter, C);

			digest.update(seed, 0, seed.length);
			digest.update(C, 0, C.length);
			digest.doFinal(hashBuf, 0);

			System.arraycopy(hashBuf, 0, out, outOff + counter * hLen, len - (counter * hLen));
		}

		return len;
	}
}
