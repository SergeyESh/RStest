package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

public class CustomViewMatcher {
    public static BoundedMatcher<View, RecyclerView> recyclerViewSizeMatcher (int size) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            String result;

            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("Expected: " + size);
                description.appendText("\nActual:");
                description.appendText(result);
            }

            @Override
            protected boolean matchesSafely(RecyclerView item) {
                int items = item.getAdapter().getItemCount();
                result = "List size: " + items;
                return size == items;
            }
        };
    }
}
