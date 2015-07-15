package repack.org.bouncycastle.crypto.params;

import repack.org.bouncycastle.crypto.KeyGenerationParameters;

import java.security.SecureRandom;

public class ECKeyGenerationParameters
		extends KeyGenerationParameters
{
	private ECDomainParameters domainParams;

	public ECKeyGenerationParameters(
			ECDomainParameters domainParams,
			SecureRandom random)
	{
		super(random, domainParams.getN().bitLength());

		this.domainParams = domainParams;
	}

	public ECDomainParameters getDomainParameters()
	{
		return domainParams;
	}
}
