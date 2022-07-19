package com.sryzzz.ecommerce.constant;

/**
 * @author sryzzz
 * @create 2022/7/19 10:50
 * @description 授权需要使用的一些常量信息
 */
public final class AuthorityConstant {

    /**
     * RSA 私钥, 除了授权中心以外, 不暴露给任何客户端
     */
    public static final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoI" +
            "BAQCct1s3vnj5SkiGiVpLTfQiWpUuCvINOI3+AwETir9Kc8APECFlU3tJ50U+SWE/xdVmtNLPrWRttS8" +
            "9X9K/hIPtybgbvuuy/TnK7qijVlHzX95gp4jGM5bI/JaMLdr6HxWNp2XwNyyZyMsCxFvGJs3XCGatU2" +
            "O+Vuy0ZvTEOj2VAVYOeGoytrbbFya1bTiDj90xItTqC09NUdGitn97Yh2VLVgZMP9xwms58LQ5V+6k" +
            "ZcphxJ0bAMZfnRo7dHr2EXCwhqlaqtzFaRnQuo4sihjC5MhqtTshbjSoDI8Idhjv0cv5afJpfJ/GT" +
            "Y/+MYAZjqJ451sJH0DwSxGtAG+lsYjbAgMBAAECggEBAIcYyVnUqRS+JKdV4LDqEntK+y8l4GPl" +
            "TQKcNGFUSnM0NWzGywM+ZBnhdJ+tQlhngv93AgRlxR2OA5s078iJw/FI452HiEhUY229L0MfNqZH" +
            "Drzjr9SsxF+e32kYXp0gDsR+ejIKXjh0EA3il/rJmMi2RU1FhcafyI378yT10ACSO9Y4R4Do8yuJ" +
            "vn+YAchUWlyM7V/lTcZG9uJb0Chmsyut+DgmZBEa+62o7HYMoSb04nKtY7OCn+q7SPYgBAB1xYNueh" +
            "EfDejUvI+4tj4MdTMd/Q9RTiGVdzehTsO40hBD86rv3ejQya9+KkaTLYxceeUam1sFVZKOnRmnei3a" +
            "G4ECgYEA2SXdTA7mLoPyQvDHGuL+7VMFMry2EfVagJBk43qAsHmE2eE+MP6jdR6p1rsSOqljZbcyMrD" +
            "H5yBohw8UiYzaOs0/fpmRVsykYCMqnfeINKF8byG/Hda8qIGb43ZnaoXY6x+HyIDzkBbho17XY1bk6w" +
            "g7v76gwNbmS6JeJF3EPDcCgYEAuMGCZ8JMkBPgnv7D1bR53pu+nNOQoNWpLH0sMAfhzwuz7jRUaNece" +
            "YLcBpsWHCXUdSmFe02zYfpHaIlaPfg3HGX6i4toaJK/exb0UyPP/vUq8JsvQayNnqanvePy4yc+iJ9uj" +
            "retAqJDbLWxmh3APGY1t+c8z+L/yBtJ02nD7n0CgYA2SGfkvoi+Mg/auhQb3Yj6zNks0M32+U2xe+cs" +
            "kpAfDZGvYcZJOy6jdZHhcwxgi72kTMKIt3aRiaF3ucZZiFN5hZuMy1jwyOGCgugBa0KqXYAcy+PZ0re" +
            "ArD3LA+tgTqtmQ5CPB+VbLM0lKO1REQTS2FEPYtkOu+oAGEvObX5DywKBgDWDJugyqMZaW4bxt3sga" +
            "OQHLDB0PsG24OcX4kKPJeI4O4dU9NXhDVtMgboQFVlVw7GjsxvBp6FLQn+OuOqWCDBbgTQFztnrFzb" +
            "psR6bktT/4c4KxKc6+VHoZ1Fiwqj0ZvJfa0A/BwdqRCkqfyRqVZGo8QoxGbYEw50L+lgXnD5pAoGBA" +
            "Lnvl3N4Wi1zBb9/aHoGgkbYe5ZAA5sWcknl+tonVWPf/u6XpZeIzf6WSAH7fsYzaJRl4Y4X5NexwSFA" +
            "PVURkdt6WJegEeNSr75vt71ZEcpu1PmGgmJ0ql7bclXoEadEAhI3AfI7rjcCG6hbKApOBXszJxpnW6o" +
            "G6EJLhzk5ruOi";

    /**
     * 默认的 Token 超时时间, 一天
     */
    public static final Integer DEFAULT_EXPIRE_DAY = 1;
}
