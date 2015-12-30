package com.kenkataiwa.kamusi;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        /*
         *  text_auto_linkify shows the android:autoLink property, which
         *  automatically linkifies things like URLs and phone numbers
         *  found in the text. No java code is needed to make this
         *  work.
         *  This can also be enabled programmatically by calling
         *  .setAutoLinkMask(Linkify.ALL) before the text is set on the TextView.
         *
         *  See android.text.util.Linkify for other options, for example only
         *  auto-linking email addresses or phone numbers
         */

        /*
         * text_html_resource has links specified by putting anchor tags (<a>) in the string
         * resource. By default these links will appear but not
         * respond to user input. To make them active, you need to
         * call setMovementMethod() on the TextView object.
         */
        TextView textViewResource = (TextView) findViewById(R.id.text_html_resource);
        textViewResource.setText(
                Html.fromHtml(getResources().getString(R.string.link_text_manual)));
        textViewResource.setMovementMethod(LinkMovementMethod.getInstance());

        /*
         * text_html_program shows creating text with links from HTML in the Java
         * code, rather than from a string resource. Note that for a
         * fixed string, using a (localizable) resource as shown above
         * is usually a better way to go; this example is intended to
         * illustrate how you might display text that came from a
         * dynamic source (eg, the network).
         */
        TextView textViewHtml = (TextView) findViewById(R.id.text_html_program);
        textViewHtml.setText(
                Html.fromHtml(
                        "<b>text_html_program: Constructed from HTML programmatically.</b>"
                                + "  Text with a <a href=\"http://www.google.com\">link</a> "
                                + "created in the Java source code using HTML."));
        textViewHtml.setMovementMethod(LinkMovementMethod.getInstance());

        /*
         * text_spannable illustrates constructing a styled string containing a
         * link without using HTML at all. Again, for a fixed string
         * you should probably be using a string resource, not a
         * hardcoded value.
         */
        SpannableString ss = new SpannableString(
                "text_spannable: Manually created spans. Click here to dial the phone.");

        /*
         * Make the first 38 characters bold by applying a StyleSpan with bold typeface.
         *
         * Characters 45 to 49 (the word "here") is made clickable by applying a URLSpan
         * pointing to a telephone number. Clicking it opens the "tel:" URL that starts the dialer.
         *
         * The SPAN_EXCLUSIVE_EXCLUSIVE flag defines this span as exclusive, which means
         * that it will not expand to include text inserted on either side of this span.
         */
        ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 39,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        ss.setSpan(new URLSpan("tel:4155551212"), 40 + 6, 40 + 10,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textViewSpan = (TextView) findViewById(R.id.text_spannable);
        textViewSpan.setText(ss);

        /*
         * Set the movement method to move between links in this TextView.
         * This means that the user traverses through links in this TextView, automatically
         * handling appropriate scrolling and key commands.
         */
        textViewSpan.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

}