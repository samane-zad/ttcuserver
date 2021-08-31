package ac.ttcu.common;

import ac.ttcu.controller.AuthenticationResource;
import ac.ttcu.security.JWTUtils;
import com.ghasemkiani.util.icu.PersianDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class Utils {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationResource.class);
    private static Map formatHolder = new HashMap();


    public static String fetchUsername(HttpHeaders httpHeaders) {
        String username = JWTUtils.getUsername(httpHeaders.get("Authorization").get(0));
        return username;
    }

    public static String fetchUserType() {
        String role = JWTUtils.getUserType();
        role = role.replace('[', ' ').replace(']', ' ').trim();
        return role;
    }
    public static String fetchPassword() {
        String password = JWTUtils.getPassword();
        return password;
    }

    public static String convertGregorianToPersian(Date gregorianDate, String pattern) throws NullPointerException, IllegalArgumentException {
        PersianDateFormat persianDateFormat = (PersianDateFormat) getFormat(pattern, null, true);
        return persianDateFormat.format(gregorianDate);
    }



    private static Object getFormat(String pattern, Locale locale, boolean persianFormat) {
        String formatKey = locale != null ? pattern + locale.toString() : pattern;
        formatKey = formatKey + persianFormat;
        if (formatHolder.get(formatKey) == null) {
            if (locale != null) {
                formatHolder.put(formatKey, persianFormat ? new PersianDateFormat(pattern, locale) : new SimpleDateFormat(pattern, locale));
            } else {
                formatHolder.put(formatKey, persianFormat ? new PersianDateFormat(pattern) : new SimpleDateFormat(pattern));
            }
        }

        return formatHolder.get(formatKey);
    }

    public static String getPersianDate(Date date)
    {
        String[] dateTime = convertGregorianToPersian(date.from(Instant.now()), "yyyy/MM/dd HH:mm").split("\\s");
        return dateTime[0];
    }
    public static String getPersianTime(Date date)
    {
        String[] dateTime = convertGregorianToPersian(date.from(Instant.now()), "yyyy/MM/dd HH:mm").split("\\s");
        return dateTime[1];
    }
}
