package net.sf.uadetector.json.internal.data.comparator;

import javax.annotation.Nonnull;

import net.sf.uadetector.internal.data.domain.BrowserType;
import net.sf.uadetector.internal.util.CompareNullSafe;

public final class BrowserTypeIdComparator extends CompareNullSafe<BrowserType> {

	private static final long serialVersionUID = 2986619675225696748L;

	public static int compareId(@Nonnull final BrowserType b1, @Nonnull final BrowserType b2) {
		final int id1 = b1.getId();
		final int id2 = b2.getId();
		return (id1 < id2 ? -1 : (id1 == id2 ? 0 : 1));
	}

	@Override
	public int compareType(@Nonnull final BrowserType b1, @Nonnull final BrowserType b2) {
		return compareId(b1, b2);
	}

}
