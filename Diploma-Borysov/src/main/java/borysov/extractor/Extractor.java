package borysov.extractor;

import javax.servlet.http.HttpServletRequest;

public interface Extractor<T> {
    T extract(HttpServletRequest request);

}
