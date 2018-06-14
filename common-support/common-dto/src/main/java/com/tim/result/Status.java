package com.tim.result;

/**
 * @description: HTTP状态码常量
 *  编号	已定义范围	分类
	1XX	100-101	信息提示
	2XX	200-206	成功
	3XX	300-305	重定向
	4XX	400-415	客户端错误
	5XX	500-505	服务器错误
	1XXX 1000-~ 业务状态码
 * @author: lizhiming
 * @since: 2017/11/10
 */
public class Status {

	//#########################自定义业务状态码【常用状态码】##############################
	/**
	 * 1000-1099(处理成功) 服务器处理请求，并成功返回处理结果
	 */
	public final static int SUCCESS = 1000;
	public final static String SUCCESS_MSG = "成功";
	public final static int FAILURE = 1001;
	public final static String FAILURE_MSG = "操作失败";
	public final static int DATA_VALIDATE_FAIL = 1002;
	public final static String DATA_VALIDATE_FAIL_MSG = "数据校验失败";
	public final static int FREQUENT_OPERATION = 1003;
	public final static String FREQUENT_OPERATION_MSG = "您的操作过于频繁，请稍后再试！";
	public final static int REPETITION_SUBMIT = 1004;
	public final static String REPETITION_SUBMIT_MSG = "请勿重复提交！";

	/**
	 * 1100-1199 短信类
	 */
	public final static int SMS_SEND_SUCCESS = 1000;
	public final static String SMS_SEND_SUCCESS_MSG = "短信发送成功！";
	
	public final static int SMS_REGISTER_TIMES_MORE = 1101;
	public final static String SMS_REGISTER_TIMES_MORE_MSG = "您的操作过于频繁，请稍后再试！";

	public final static int SMS_GET_FAIL = 1102;
	public final static String SMS_GET_FAIL_MSG = "获取验证码失败";

	public final static int SMS_PHONE_NOT_EMPTY = 1103;
	public final static String SMS_PHONE_NOT_EMPTY_MSG = "手机号码不能为空！";

	public final static int SMS_PHONE_FORMAT_ERROR = 1104;
	public final static String SMS_PHONE_FORMAT_ERROR_MSG = "手机号码格式错误！";

	public final static int SMS_CODE_TIMES_MORE_LIMIT = 1105;
	public final static String SMS_CODE_TIMES_MORE_LIMIT_MSG = "由于您的动态码获取次数超过限制，您的手机将在48小时内无法获取动态码信息！";

	public final static int SMS_CODE_TIMES_LIMIT_ONE_HOUR = 1106;
	public final static String SMS_CODE_TIMES_LIMIT_ONE_HOUR_MSG = "由于您的动态码获取次数超过限制，您的手机将在1小时内无法获取动态码信息!";

	public final static int SMS_IMG_CODE_TIMEOUT = 1107;
	public final static String SMS_IMG_CODE_TIMEOUT_MSG = "图形验证码已超时！";

	public final static int SMS_IMG_CODE_ERROR = 1108;
	public final static String SMS_IMG_CODE_ERROR_MSG = "图形验证码出错！";

	public final static int SMS_PARAM_ERROR = 1109;
	public final static String SMS_PARAM_ERROR_MSG = "参数错误，请重新尝试！";

	public static final int SMS_OFFEN_REQUEST = 1111;
	public static final String SMS_OFFEN_REQUEST_MSG = "身份验证之后,动态码请求过于频繁";
;
	public static final int SMS_REQUEST_TIMEOUT = 1112;
	public static final String SMS_REQUEST_TIMEOUT_MSG = "请求超时，请刷新页面重试！";

	public static final int SMS_SEND_TARGER_EMPTY = 1113;
	public static final String SMS_SEND_TARGER_EMPTY_MSG = "短信类型或发送目标或发送内容为空！";

	public static final int SMS_PHONE_EXIST = 1114;
	public static final String SMS_PHONE_EXIST_MSG = "该手机号码已存在！";

	public static final int SMS_SERVICE_TEMPORARILY_UNAVAILABLE = 1115;
	public static final String SMS_SERVICE_TEMPORARILY_UNAVAILABLE_MSG = "该服务暂不可用";

	public static final int SMS_PHONE_NOT_SEND_CODE = 1116;
	public static final String SMS_PHONE_NOT_SEND_CODE_MSG = "该手机目前无法发送动态口令,动态口令发送过于频繁";

	public static final int SMS_CODE_SEND_FAIL = 1117;
	public static final String SMS_CODE_SEND_FAIL_MSG = "验证码发送失败";

	public static final int SMS_CODE_ERROR = 1118;
	public static final String SMS_CODE_ERROR_MSG = "验证码错误";

	public static final int SMS_CODE_TIMEOUT = 1119;
	public static final String SMS_CODE_TIMEOUT_MSG = "验证码超时";


	/**
	 * 微信支付类
	 */
	public static final int WECHAT_PAY_CODE_ERROR = 1120;
	public static final String WECHAT_PAY_PAY_CODE_ERROR_MSG = "支付失败";
	
	public static final int WECHAT_PAY_SEND_CODE_ERROR = 1121;
	public static final String WECHAT_PAY_SEND_CODE_ERROR_MSG = "请使用微信打开！";
	
	public static final int WECHAT_PAY_OPENID_CODE_ERROR = 1122;
	public static final String WECHA_PAYT_OPENID_CODE_ERROR_MSG = "openid为空";
	
	public static final int WECHAT_PAY_CREATE_CODE_ERROR = 1122;
	public static final String WECHAT_PAY_CREATE_CODE_ERROR_MSG = "生成订单出错！";

	
	/**
	 * 1200-1299 同盾类
	 */

	/**
	 * 1300-1399 微信
	 */
	public final static int WECHAT_CODE_USED = 1300;
	public final static String WECHAT_CODE_USED_MSG = "微信获取码已被使用";

	public final static int WECHAT_OPENID_NOT_EXIST = 1301;
	public final static String WECHAT_OPENID_NOT_EXIST_MSG = "微信OPENID为空";

	public final static int WECHAT_GET_OPENID_ERROR = 1302;
	public final static String WECHAT_GET_OPENID_ERROR_MSG = "微信获取OPENID异常";

	public final static int WECHAT_USER_LIKED = 1303;
	public final static String WECHAT_USER_LIKED_MSG = "微信用户已点过赞";

	/**
	 * 1400-1499 用户
	 */
	public final static int USER_LOGIN_NO_EXISTSC_CODE = 1401;
	public final static String USER_LOGIN_NO_EXISTS_MSG = "账号不存在";
	
	public final static int USER_LOGIN_PASSWORD_ERR_CODE = 1402;
	public final static String USER_LOGIN_PASSWORD_ERR_MSG = "密码错误";
	
	public final static int USER_LOGIN_HAS_REGIST_CODE = 1403;
	public final static String USER_LOGIN_HAS_REGIST_MSG = "您已注册";

	public final static int USER_ACCOUNT_OR_PASSWORD_EMPTY = 1404;
	public final static String USER_ACCOUNT_OR_PASSWORD_EMPTY_MSG= "账号或密码不能为空";

	public final static int USER_ACCOUNT_OR_PASSWORD_ERROR = 1405;
	public final static String USER_ACCOUNT_OR_PASSWORD_ERROR_MSG= "账号或密码错误";

	public final static int USER_MORE_TIMES_REGISTER = 1406;
	public final static String USER_MORE_TIMES_REGISTER_MSG= "该手机号已注册";

	public final static int USER_REGISTER_FAIL = 1407;
	public final static String USER_REGISTER_FAIL_MSG= "注册失败";


	public final static int USER_FACE_TOKEN_FAIL_CODE = 1415;
	public final static String USER_FACE_TOKEN_MSG= "请拨打客服电话：0755-86728705";
	
	
	public final static int USER_FACE_INFO_GET_FAIL_CODE = 1416;
	public final static String USER_FACE_INFO_GET_FAIL_MSG= "人脸识别信息处理错误";
	
	public final static int USER_ZHIMA_AUTHEN_FAIL_CODE = 1417;
	public final static String USER_ZHIMA_AUTHEN_FAIL_MSG= "芝麻信用认证异常";

	public final static int USER_REAL_NAME_FAIL = 1408;
	public final static String USER_REAL_NAME_FAIL_MSG= "实名认证失败";

	public final static int USER_IDCARD_ERROR = 1409;
	public final static String USER_IDCARD_ERROR_MSG= "身份证号码错误";

	public final static int USER_NOT_EIGHTEEN = 1410;
	public final static String USER_NOT_EIGHTEEN_MSG= "本平台仅接受年满18周岁且具有完全民事行为能力的用户进行投资";

	public final static int USER_VALIDATE_INFO = 1411;
	public final static String USER_VALIDATE_INFO_MSG= "校验身份证信息失败";

	public final static int USER_BANK_CARD_EMPTY = 1412;
	public final static String USER_BANK_CARD_EMPTY_MSG= "银行卡号码不能为空";

	public final static int USER_BANK_CARD_FORMAT = 1413;
	public final static String USER_BANK_CARD_FORMAT_MSG= "银行卡号格式不正确";

	public final static int USER_ZHIMA_AUTH_EXCEPT_CODE = 1418;
	public final static String USER_ZHIMA_AUTH_EXCEPT_MSG= "授权芝麻信用异常";

	public final static int USER_ZHIMA_HAS_AUTHED_CODE = 1419;
	public final static String USER_ZHIMA_HAS_AUTHED_MSG= "芝麻信用已授权";
	
	public final static int USER_QUERY_ZHIMA_AUTH_EXCEPT_CODE = 1420;
	public final static String USER_QUERY_ZHIMA_AUTH_EXCEPT_MSG= "查询芝麻认证状态异常";

	public final static int USER_APPLY_FAIL_CODE = 1421;
	public final static String USER_APPLY_FAIL_MSG= "借款失败！";

	public final static int USER_EXIST_BORROW_CODE = 1423;
	public final static String USER_EXIST_BORROW_MSG= "您存在未结清的借款记录！";
	
	public final static int  USER_REPAY_MONEY_ERROR_CODE= 1423;
	public final static String USER_REPAY_MONEY_ERROR_MSG= "还款金额错误！";

	public final static int  USER_TRUE_ERROR_CODE= 1424;
	public final static String USER_TRUE_ERROR_MSG= "已存在分期信息，请勿重复确认！";
	
	//#########################http状态返回代码 1xx（临时响应）##############################
	/**
	 * （继续） 请求者应当继续提出请求。 服务器返回此代码表示已收到请求的第一部分，正在等待其余部分
	 */
	public final static int CONTINUE = 100;
	public final static String CONTINUE_MSG = "继续";

	/**
	 * （切换协议） 请求者已要求服务器切换协议，服务器已确认并准备切换
	 */
	public final static int SWITCHING_PROTOCOLS = 101;
	public final static String SWITCHING_PROTOCOLS_MSG = "切换协议";


	//#########################http状态返回代码 2xx （成功）################################
	/**
	 * （成功）  服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页
	 */
	public final static int OK = 200;
	public final static String OK_MSG = "成功";


	//#########################http状态返回代码 3xx （重定向）###############################
	/**
	 * （多种选择）  针对请求，服务器可执行多种操作
	 */
	public final static int MULTIPLE_CHOICES = 300;
	public final static String MULTIPLE_CHOICES_MSG = "多种选择";


	//#########################http状态返回代码 4xx（请求错误）##############################
	/**
	 * （错误请求） 服务器不理解请求的语法
	 */
	public final static int BAD_REQUEST = 400;
	public final static String BAD_REQUEST_MSG = "错误请求";
	/**
	 * （未授权） 请求要求身份验证
	 */
	public final static int UNAUTHORIZED = 401;
	public final static String UNAUTHORIZED_MSG = "未授权";
	/**
	 * （禁止） 服务器拒绝请求
	 */
	public final static int FORBIDDEN = 403;
	public final static String FORBIDDEN_MSG = "禁止";
	/**
	 * （未找到） 服务器找不到请求的网页
	 */
	public final static int NOT_FOUND = 404;
	public final static String NOT_FOUND_MSG = "未找到";


	//#########################http状态返回代码 5xx（服务器错误）############################
	/**
	 * （服务器内部错误） 服务器遇到错误，无法完成请求
	 */
	public final static int INTERNAL_SERVER_ERROR = 500;
	public final static String INTERNAL_SERVER_ERROR_MSG = "服务器内部错误";
	/**
	 * （服务不可用） 服务器目前无法使用（由于超载或停机维护）
	 */
	public final static int SERVICE_UNAVAILABLE = 503;
	public final static String SERVICE_UNAVAILABLE_MSG = "服务不可用";
	/**
	 * （网关超时）  服务器作为网关或代理，但是没有及时从上游服务器收到请求
	 */
	public final static int GATEWAY_TIMEOUT = 504;
	public final static String GATEWAY_TIMEOUT_MSG = "网关超时";

}