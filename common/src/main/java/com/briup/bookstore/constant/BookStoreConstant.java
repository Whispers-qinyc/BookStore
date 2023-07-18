package com.briup.bookstore.constant;

public class BookStoreConstant {

    /*
     * 服务网关  ---  沙箱环境
     */

    public static final String SERVER_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    /*
     * 应用id,
     */

    public static final String APP_ID = "2021000122667872";

    /*
     * 用户私钥,可以替换成你们的自己的私钥
     *
     */

    public static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqSCAkJ26dN/ZIbQqrYLJKhdwjKSfVrwo6pj5i/YOw6vaezWQ15hDFFOIeR+LdKuGCps4IEm5slqRZv32TUgu1fTWXT90Wt5FisK5NjZiCX6gVycRqamHMhyEfeMepjuCWpSwR/aW+7WmWRaZE1KiUqbbFv4rFcraxR0f/qD7ng+AyElrLETVY/nRnwglMi62uziDq2TJfGpMeexA/Jw9uQXxPrm8a+GiD+562+7a8PUnaJ6c39LEAoAcRY+QwgZ3129yCzUzzymyuublVAN58Pqc4Jrz0zbgzP2VkzyyCOgHnNo9rz0M3rtVc5Amf8lnoGXYWyUsyt7/1OFyYdRnnAgMBAAECggEBAJVqSFmxCAyIaGDQ3YXXiVp+7tUjbcLAnvcrnJ572SxKYDCkBQSOZbSpSGhNp7FtyQc9mpfWpHJAFOJzdproaUHNJlMpTtR6KuYwJiIC1wm/KdxEeUbvJfWztMrKzlfn+QX21R7MNL290OJ9JxJKj8oyyR/nnLr4l3ojE/gvB1NZIiPBuQT0XeqYTGGcxdLOR1dZ9EEGMM/ptIfT+PJ1WTQ4hmrlAF/52vKk7NU2yDnMaeDJrBFwk3kath/2nnk0XNsimf/dCf3OufEeHRj7svAFHbQUQh8XkVa24nT4IH/sGgpwcgfsMiXZ38uK0YD1bx/zcXJJyPUnb7D7J2hUdzECgYEA5g9YvDwoK5YgUP/qqtyVCG+qNAaSQC0wnBq8GJiSEuj44ekYDrXEdxgpOkJPK5gqOU3El/RtXxcICNfa3F3fE6xcaRxLq7zKgJ8xMyyUMyo3vEvaNdrJKN0gi35RNNrqF4Mruw0xL2zmAf6VvccknIer5rxq7syAC/zmoMMVfo0CgYEAvXtJugWz09HsJd9NXlCIsAfDovrmE94Dw9lIh9k7cjwSbpAZBQhyMQ+DAwivpz8VqC+iFUcNLcZhP9cGSCsoa63sA5bWoZ7hr+18gyueBW7kREyUp0gPC9TnecDEA1EbSaMcqTjUkyfDRYD/7sD0xZ+81rTJRsugMtwS6NMjp0MCgYBEzMwdpuPgfQn3D0GPjV3oYvSEkH6GQL1rwbcEqAPvMcrUTJAMPiGd+BTEPnZMtDnUX0RuqQNYT5vwgRULl+sRiBcuu+6JUnFA29qr0iYT0wlN/2Une+FyngaQkNsaMmmVVH3sd3qBE1EJwafoVDjHsu8elrRn67JTY3NZGl5ANQKBgBzq/fuH90Pym8nD5LjqLZI//RmYlRifH4/6T1l8S9hJVr7M+ySLf3IBXgtOfhBWTmXWrzP0HgzIY/ssQ+crvwWAC68YjDUqXGNPKVuTgpBttiS+U0mcc79ohNNOGhwveqyoWi1xYO/8d47Z+zVi+XhXwqg5+yX02cQpVjF2V9ClAoGBAIPVZlQWZkI/I3dUCXAwN3lLhL5SaAmqLGvKtdtzlSF4P2rK2ROt+0hrm7wy7p45l5eO4k2D3IIhHTK4iXkTAFGwD5hHBeHd/ijbg4gPv64463CryWTvCN9o4I7jRwz3mrnpO1FtuEqAJliR+H/OySrNfXq8y10Q9qs0fgFPuH66";

    /*
     * 发送数据的格式,  目前为json
     *
     */

    public static final String FORMAT = "json";

    /*
     * 设置字符集的编码格式 utf-8
     */

    public static final  String CHARSET = "utf-8";

    /*
     * 支付宝公钥
     */

    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArK5a2TOoijdhLNbdRwRwzfjoaGR7G8dUmIo5rWuxTfIPV+p+jpu38j6/vg2RUS6p9nn8B+tAFPnyLI+UWUgXh+GOJwP8z4n7mIoL8cYleWBJvAAE+1qI0nBoANNlFBRKjQT92/aZ/v4ZBPYasmCifC0APqmDC8PwujaC79BeJH0IZkY4pggdXKpjOR2J9R5gBv1DMfc6XVunKilES9j8O7tqY7munhuOxPqNvK49uGN8vRuBVDWJwnlyseWQ0T8hxd9JXESvz+Z7XGNk6GeRqs47tsVXXEpC2EUUW7ph4MxVTMfK9By0xrpc5BbOYqiqjoVQUfrX2S8oTt+dX9lhQQIDAQAB";

    /*
     * 支付宝签名  目前采用的是RSA2
     */

    public static final String SIGN_TYPE = "RSA2";



}
