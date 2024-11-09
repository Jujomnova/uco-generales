package co.edu.uco.ucobet.generales.crosscutting.helpers;

import java.util.Random;
import java.util.regex.Pattern;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERSCORE = "_";
	private static final Random RANDOM = new Random();

	private TextHelper() {

	}

	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}

	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}

	public static final String concatenate(String... strings)
	{
		final var sb = new StringBuilder(EMPTY);

		if (!ObjectHelper.isNull(strings))
		{
			for (final var str : strings)
			{
				sb.append(applyTrim(str));
			}
		}

		return sb.toString();
	}

	public static final String replaceExceptionMessageParams(final String exceptionMessage, final String... params)
	{
		String newString = exceptionMessage;

		for (int i=0; i < params.length; i++)
		{
			final String currentParameter = params[i];

			newString = newString.replace("{"+i+"}", currentParameter);
		}

		return applyTrim(newString);
	}

	public static final long getCountMessageParameters(final String original)
	{
		Pattern pattern = Pattern.compile("\\{\\d\\}");
		return pattern.matcher(original).results().count();
	}

	public static final String generateTicket()
	{
		StringBuilder ticketBuilder = new StringBuilder();

		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				int randomInt = RANDOM.nextInt(16);
				String hexDigit = Integer.toHexString(randomInt).toUpperCase();

				ticketBuilder.append(hexDigit);
			}

			if (i<2)
			{
				ticketBuilder.append("-");
			}
		}

		return ticketBuilder.toString();
	}
}
