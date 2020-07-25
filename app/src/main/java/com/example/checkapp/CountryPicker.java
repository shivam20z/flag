package com.example.checkapp;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CountryPicker implements BottomSheetInteractionListener, LifecycleObserver {

  // region Countries

  private final Country[] COUNTRIES = {
          new Country( "Andorra" ,R.drawable.flag_ad),
          new Country( "United Arab Emirates",  R.drawable.flag_ae),
          new Country( "Afghanistan", R.drawable.flag_af),
          new Country( "Antigua and Barbuda",R.drawable.flag_ag),
          new Country( "Anguilla",R.drawable.flag_ai),
          new Country( "Albania", R.drawable.flag_al),
          new Country( "Armenia", R.drawable.flag_am),
          new Country( "Angola", R.drawable.flag_ao),
          new Country( "Antarctica",R.drawable.flag_aq),
          new Country( "Argentina",R.drawable.flag_ar),
          new Country( "American Samoa",R.drawable.flag_as),
          new Country( "Austria",R.drawable.flag_at),
          new Country( "Australia",R.drawable.flag_au),
          new Country( "Aruba",R.drawable.flag_aw),
          new Country( "Aland Islands",R.drawable.flag_ax),
          new Country( "Azerbaijan",R.drawable.flag_az),
          new Country( "Bosnia and Herzegovina",R.drawable.flag_ba),
          new Country( "Barbados",R.drawable.flag_bb),
          new Country( "Bangladesh",R.drawable.flag_bd),
          new Country( "Belgium",R.drawable.flag_be),
          new Country( "Burkina Faso",R.drawable.flag_bf),
          new Country( "Bulgaria",R.drawable.flag_bg),
          new Country( "Bahrain",R.drawable.flag_bh),
          new Country( "Burundi",R.drawable.flag_bi),
          new Country( "Benin",R.drawable.flag_bj),
          new Country( "Saint Barthelemy",R.drawable.flag_bl),
          new Country( "Bermuda",R.drawable.flag_bm),
          new Country( "Brunei Darussalam", R.drawable.flag_bn),
          new Country( "Bolivia, Plurinational State of", R.drawable.flag_bo),
          new Country( "Bonaire",R.drawable.flag_bq),
          new Country( "Brazil",R.drawable.flag_br),
          new Country( "Bahamas",R.drawable.flag_bs),
          new Country( "Bhutan",R.drawable.flag_bt),
          new Country( "Bouvet Island",R.drawable.flag_bv),
          new Country( "Botswana",R.drawable.flag_bw),
          new Country( "Belarus",R.drawable.flag_by),
          new Country( "Belize",R.drawable.flag_bz),
          new Country( "Canada",R.drawable.flag_ca),
          new Country( "Cocos (Keeling) Islands",R.drawable.flag_cc),
          new Country( "Congo, The Democratic Republic of the",R.drawable.flag_cd),
          new Country( "Central African Republic",R.drawable.flag_cf),
          new Country( "Congo",R.drawable.flag_cg),
          new Country( "Switzerland",R.drawable.flag_ch),
          new Country( "Ivory Coast",R.drawable.flag_ci),
          new Country( "Cook Islands",R.drawable.flag_ck),
          new Country( "Chile",R.drawable.flag_cl),
          new Country( "Cameroon",R.drawable.flag_cm),
          new Country( "China",R.drawable.flag_cn),
          new Country( "Colombia",R.drawable.flag_co),
          new Country( "Costa Rica",R.drawable.flag_cr),
          new Country( "Cuba",R.drawable.flag_cu),
          new Country( "Cape Verde",R.drawable.flag_cv),
          new Country( "Curacao",R.drawable.flag_cw),
          new Country( "Christmas Island",R.drawable.flag_cx),
          new Country( "Cyprus",R.drawable.flag_cy),
          new Country( "Czech Republic",R.drawable.flag_cz),
          new Country( "Germany",R.drawable.flag_de),
          new Country( "Djibouti",R.drawable.flag_dj),
          new Country( "Denmark",R.drawable.flag_dk),
          new Country( "Dominica",R.drawable.flag_dm),
          new Country( "Dominican Republic",R.drawable.flag_do),
          new Country( "Algeria",R.drawable.flag_dz),
          new Country( "Ecuador", R.drawable.flag_ec ),
          new Country( "Estonia", R.drawable.flag_ee ),
          new Country( "Egypt",R.drawable.flag_eg),
          new Country( "Western Sahara",R.drawable.flag_eh),
          new Country( "Eritrea",R.drawable.flag_er),
          new Country( "Spain",R.drawable.flag_es),
          new Country( "Ethiopia",R.drawable.flag_et),
          new Country( "Finland",R.drawable.flag_fi),
          new Country( "Fiji",R.drawable.flag_fj),
          new Country( "Falkland Islands (Malvinas)",R.drawable.flag_fk),
          new Country( "Micronesia, Federated States of",R.drawable.flag_fm),
          new Country( "Faroe Islands",R.drawable.flag_fo),
          new Country( "France",R.drawable.flag_fr),
          new Country( "Gabon",R.drawable.flag_ga),
          new Country( "United Kingdom",R.drawable.flag_gb),
          new Country( "Grenada",R.drawable.flag_gd),
          new Country( "Georgia",R.drawable.flag_ge),
          new Country( "French Guiana",R.drawable.flag_gf),
          new Country( "Guernsey",R.drawable.flag_gg),
          new Country( "Ghana",R.drawable.flag_gh),
          new Country( "Gibraltar",R.drawable.flag_gi),
          new Country( "Greenland",R.drawable.flag_gl),
          new Country( "Gambia",R.drawable.flag_gm),
          new Country( "Guinea",R.drawable.flag_gn),
          new Country( "Guadeloupe",R.drawable.flag_gp),
          new Country( "Equatorial Guinea",R.drawable.flag_gq),
          new Country( "Greece",R.drawable.flag_gr),
          new Country( "South Georgia and the South Sandwich Islands",R.drawable.flag_gs),
          new Country( "Guatemala", R.drawable.flag_gt),
          new Country( "Guam",R.drawable.flag_gu),
          new Country( "Guinea-Bissau",R.drawable.flag_gw),
          new Country( "Guyana",  R.drawable.flag_gy),
          new Country( "Hong Kong",  R.drawable.flag_hk),
          new Country( "Heard Island and McDonald Islands", R.drawable.flag_hm),
          new Country( "Honduras",  R.drawable.flag_hn),
          new Country( "Croatia",  R.drawable.flag_hr),
          new Country( "Haiti",  R.drawable.flag_ht),
          new Country( "Hungary",  R.drawable.flag_hu),
          new Country( "Indonesia",  R.drawable.flag_id),
          new Country( "Ireland",  R.drawable.flag_ie),
          new Country( "Israel",  R.drawable.flag_il),
          new Country( "Isle of Man", R.drawable.flag_im),
          new Country( "India",  R.drawable.flag_in),
          new Country( "British Indian Ocean Territory", R.drawable.flag_io),
          new Country( "Iraq",  R.drawable.flag_iq),
          new Country( "Iran, Islamic Republic of", R.drawable.flag_ir),
          new Country( "Iceland",  R.drawable.flag_is),
          new Country( "Italy",  R.drawable.flag_it),
          new Country( "Jersey",  R.drawable.flag_je),
          new Country( "Jamaica", R.drawable.flag_jm),
          new Country( "Jordan",  R.drawable.flag_jo),
          new Country( "Japan", R.drawable.flag_jp),
          new Country( "Kenya", R.drawable.flag_ke),
          new Country( "Kyrgyzstan", R.drawable.flag_kg),
          new Country( "Cambodia",  R.drawable.flag_kh),
          new Country( "Kiribati",  R.drawable.flag_ki),
          new Country( "Comoros",  R.drawable.flag_km),
          new Country( "Saint Kitts and Nevis",  R.drawable.flag_kn),
          new Country( "North Korea", R.drawable.flag_kp),
          new Country( "South Korea",  R.drawable.flag_kr),
          new Country( "Kuwait",  R.drawable.flag_kw),
          new Country( "Cayman Islands",  R.drawable.flag_ky),
          new Country( "Kazakhstan",  R.drawable.flag_kz),
          new Country( "Lao People's Democratic Republic", R.drawable.flag_la),
          new Country( "Lebanon", R.drawable.flag_lb),
          new Country( "Saint Lucia",R.drawable.flag_lc),
          new Country( "Liechtenstein",R.drawable.flag_li),
          new Country( "Sri Lanka", R.drawable.flag_lk),
          new Country( "Liberia",R.drawable.flag_lr),
          new Country( "Lesotho",R.drawable.flag_ls),
          new Country( "Lithuania",R.drawable.flag_lt),
          new Country( "Luxembourg",R.drawable.flag_lu),
          new Country( "Latvia",R.drawable.flag_lv),
          new Country( "Libyan Arab Jamahiriya",R.drawable.flag_ly),
          new Country( "Morocco",R.drawable.flag_ma),
          new Country( "Monaco",R.drawable.flag_mc),
          new Country( "Moldova, Republic of",R.drawable.flag_md),
          new Country( "Montenegro",R.drawable.flag_me),
          new Country( "Saint Martin",R.drawable.flag_mf),
          new Country( "Madagascar",R.drawable.flag_mg),
          new Country( "Marshall Islands",R.drawable.flag_mh),
          new Country( "Macedonia, The Former Yugoslav Republic of",R.drawable.flag_mk),
          new Country( "Mali",R.drawable.flag_ml),
          new Country( "Myanmar",R.drawable.flag_mm),
          new Country( "Mongolia",R.drawable.flag_mn),
          new Country( "Macao",R.drawable.flag_mo),
          new Country( "Northern Mariana Islands",R.drawable.flag_mp),
          new Country( "Martinique",R.drawable.flag_mq),
          new Country( "Mauritania",R.drawable.flag_mr),
          new Country( "Montserrat",R.drawable.flag_ms),
          new Country( "Malta",R.drawable.flag_mt),
          new Country( "Mauritius",R.drawable.flag_mu),
          new Country( "Maldives",R.drawable.flag_mv),
          new Country( "Malawi",R.drawable.flag_mw),
          new Country( "Mexico",R.drawable.flag_mx),
          new Country( "Malaysia",R.drawable.flag_my),
          new Country( "Mozambique",R.drawable.flag_mz),
          new Country( "Namibia",R.drawable.flag_na),
          new Country( "New Caledonia",R.drawable.flag_nc),
          new Country( "Niger",R.drawable.flag_ne),
          new Country( "Norfolk Island",R.drawable.flag_nf),
          new Country( "Nigeria",R.drawable.flag_ng),
          new Country( "Nicaragua",R.drawable.flag_ni),
          new Country( "Netherlands",R.drawable.flag_nl),
          new Country( "Norway", R.drawable.flag_no),
          new Country( "Nepal",  R.drawable.flag_np),
          new Country( "Nauru",  R.drawable.flag_nr),
          new Country( "Niue", R.drawable.flag_nu),
          new Country( "New Zealand", R.drawable.flag_nz),
          new Country( "Oman", R.drawable.flag_om),
          new Country( "Panama", R.drawable.flag_pa),
          new Country( "Peru",R.drawable.flag_pe),
          new Country( "French Polynesia",R.drawable.flag_pf),
          new Country( "Papua New Guinea",R.drawable.flag_pg),
          new Country( "Philippines",R.drawable.flag_ph),
          new Country( "Pakistan",R.drawable.flag_pk),
          new Country( "Poland",R.drawable.flag_pl),
          new Country( "Saint Pierre and Miquelon",R.drawable.flag_pm),
          new Country( "Pitcairn",R.drawable.flag_pn),
          new Country( "Puerto Rico",R.drawable.flag_pr),
          new Country( "Palestinian Territory, Occupied",R.drawable.flag_ps),
          new Country( "Portugal", R.drawable.flag_pt),
          new Country( "Palau",R.drawable.flag_pw),
          new Country( "Paraguay",R.drawable.flag_py),
          new Country( "Qatar",R.drawable.flag_qa),
          new Country( "Reunion",R.drawable.flag_re),
          new Country( "Romania",R.drawable.flag_ro),
          new Country( "Serbia",R.drawable.flag_rs),
          new Country( "Russia",R.drawable.flag_ru),
          new Country( "Rwanda",R.drawable.flag_rw),
          new Country( "Saudi Arabia",R.drawable.flag_sa),
          new Country( "Solomon Islands",R.drawable.flag_sb),
          new Country( "Seychelles",R.drawable.flag_sc),
          new Country( "Sudan",R.drawable.flag_sd),
          new Country( "Sweden",R.drawable.flag_se),
          new Country( "Singapore",R.drawable.flag_sg),
          new Country( "Saint Helena, Ascension and Tristan Da Cunha",R.drawable.flag_sh),
          new Country( "Slovenia",R.drawable.flag_si),
          new Country( "Svalbard and Jan Mayen",R.drawable.flag_sj),
          new Country( "Slovakia", R.drawable.flag_sk),
          new Country( "Sierra Leone",R.drawable.flag_sl),
          new Country( "San Marino",R.drawable.flag_sm),
          new Country( "Senegal",R.drawable.flag_sn),
          new Country( "Somalia",R.drawable.flag_so),
          new Country( "Suriname", R.drawable.flag_sr),
          new Country( "South Sudan",R.drawable.flag_ss),
          new Country( "Sao Tome and Principe",R.drawable.flag_st),
          new Country( "El Salvador",R.drawable.flag_sv),
          new Country( "Sint Maarten",R.drawable.flag_sx),
          new Country( "Syrian Arab Republic",R.drawable.flag_sy),
          new Country( "Swaziland",R.drawable.flag_sz),
          new Country( "Turks and Caicos Islands",R.drawable.flag_tc),
          new Country( "Chad",R.drawable.flag_td),
          new Country( "French Southern Territories",R.drawable.flag_tf),
          new Country( "Togo",R.drawable.flag_tg),
          new Country( "Thailand",R.drawable.flag_th),
          new Country( "Tajikistan",R.drawable.flag_tj),
          new Country( "Tokelau",R.drawable.flag_tk),
          new Country( "East Timor",R.drawable.flag_tl),
          new Country( "Turkmenistan",R.drawable.flag_tm),
          new Country( "Tunisia", R.drawable.flag_tn),
          new Country( "Tonga",R.drawable.flag_to),
          new Country( "Turkey",R.drawable.flag_tr),
          new Country( "Trinidad and Tobago",R.drawable.flag_tt),
          new Country( "Tuvalu",R.drawable.flag_tv),
          new Country( "Taiwan",R.drawable.flag_tw),
          new Country( "Tanzania, United Republic of",R.drawable.flag_tz),
          new Country( "Ukraine",R.drawable.flag_ua),
          new Country( "Uganda",R.drawable.flag_ug),
          new Country( "U.S. Minor Outlying Islands",R.drawable.flag_um),
          new Country( "United States",R.drawable.flag_us),
          new Country( "Uruguay",R.drawable.flag_uy),
          new Country( "Uzbekistan",R.drawable.flag_uz),
          new Country( "Holy See (Vatican City State)",R.drawable.flag_va),
          new Country( "Saint Vincent and the Grenadines",R.drawable.flag_vc),
          new Country( "Venezuela, Bolivarian Republic of",R.drawable.flag_ve),
          new Country( "Virgin Islands, British",R.drawable.flag_vg),
          new Country( "Virgin Islands, U.S.",R.drawable.flag_vi),
          new Country( "Vietnam",R.drawable.flag_vn),
          new Country( "Vanuatu",R.drawable.flag_vu),
          new Country( "Wallis and Futuna",R.drawable.flag_wf),
          new Country( "Samoa",R.drawable.flag_ws),
          new Country( "Kosovo",R.drawable.flag_xk),
          new Country( "Yemen",R.drawable.flag_ye),
          new Country( "Mayotte",R.drawable.flag_yt),
          new Country( "South Africa",R.drawable.flag_za),
          new Country( "Zambia", R.drawable.flag_zm),
          new Country( "Zimbabwe",R.drawable.flag_zw),
  };

  public static final int SORT_BY_NONE = 0;
  public static final int SORT_BY_NAME = 1;
  public static final int THEME_NEW = 2;
  private int theme;
  private Context context;
  private int sortBy = SORT_BY_NONE;
  private OnCountryPickerListener onCountryPickerListener;
  private boolean canSearch = true;
  private List<Country> countries;
  private EditText searchEditText;
  private RecyclerView countriesRecyclerView;
  private int textColor;
  private CountriesAdapter adapter;
  private List<Country> searchResults;
  private BottomSheetDialogView bottomSheetDialog;
  private Dialog dialog;

  private CountryPicker() {
  }

  CountryPicker(Builder builder) {
    sortBy = builder.sortBy;
    if (builder.onCountryPickerListener != null) {
      onCountryPickerListener = builder.onCountryPickerListener;
    }
    context = builder.context;
    canSearch = builder.canSearch;
    theme = builder.theme;
    countries = new ArrayList<>(Arrays.asList(COUNTRIES));
    sortCountries(countries);
  }
  // endregion

  // region Listeners
  private void sortCountries(@NonNull List<Country> countries) {
    if (sortBy == SORT_BY_NAME) {
      Collections.sort(countries, new Comparator<Country>() {
        @Override
        public int compare(Country country1, Country country2) {
          return country1.getName().trim().compareToIgnoreCase(country2.getName().trim());
        }
      });
    }
  }

  // region BottomSheet Methods
  public void showBottomSheet(AppCompatActivity activity) {
    if (countries == null || countries.isEmpty()) {
      throw new IllegalArgumentException(context.getString(R.string.error_no_countries_found));
    } else {
      activity.getLifecycle().addObserver(this);
      bottomSheetDialog = BottomSheetDialogView.newInstance(theme);
      bottomSheetDialog.setListener(this);
      bottomSheetDialog.show(activity.getSupportFragmentManager(), "bottomsheet");
    }
  }


  @Override public void setupRecyclerView(View sheetView) {
    searchResults = new ArrayList<>();
    searchResults.addAll(countries);
    adapter = new CountriesAdapter(sheetView.getContext(), searchResults,
        new OnItemClickListener() {
          @Override public void onItemClicked(Country country) {
            if (onCountryPickerListener != null) {
              onCountryPickerListener.onSelectCountry(country);
              if (bottomSheetDialog != null) {
                bottomSheetDialog.dismiss();
              }
              if (dialog != null) {
                dialog.dismiss();
              }
            }
          }
        },
        textColor);
    countriesRecyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager(sheetView.getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    countriesRecyclerView.setLayoutManager(layoutManager);
    countriesRecyclerView.setAdapter(adapter);
  }

  @Override public void setSearchEditText() {
    if (canSearch) {
      searchEditText.addTextChangedListener(new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          // Intentionally Empty
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
          // Intentionally Empty
        }

        @Override
        public void afterTextChanged(Editable searchQuery) {
          search(searchQuery.toString());
        }
      });
      searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
          InputMethodManager imm = (InputMethodManager) searchEditText.getContext()
              .getSystemService(Context.INPUT_METHOD_SERVICE);
          if (imm != null) {
            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
          }
          return true;
        }
      });
    } else {
      searchEditText.setVisibility(View.GONE);
    }
  }

  private void search(String searchQuery) {
    searchResults.clear();
    for (Country country : countries) {
      if (country.getName().toLowerCase(Locale.ENGLISH).contains(searchQuery.toLowerCase())) {
        searchResults.add(country);
      }
    }
    sortCountries(searchResults);
    adapter.notifyDataSetChanged();
  }



  @Override public void initiateUi(View sheetView) {
    searchEditText = sheetView.findViewById(R.id.country_code_picker_search);
    countriesRecyclerView = sheetView.findViewById(R.id.countries_recycler_view);
  }

  @Override
  public void setCustomStyle(View view) {

  }


  public static class Builder {
    private Context context;
    private int sortBy = CountryPicker.SORT_BY_NONE;
    private boolean canSearch = true;
    private OnCountryPickerListener onCountryPickerListener;
    private int theme = CountryPicker.THEME_NEW;

    public Builder with(@NonNull Context context) {
      this.context = context;
      return this;
    }


    public Builder listener(@NonNull OnCountryPickerListener onCountryPickerListener) {
      this.onCountryPickerListener = onCountryPickerListener;
      return this;
    }

    public CountryPicker build() {
      return new CountryPicker(this);
    }
  }

}
