# Java_RESTfulWS

REST API实践

https://segmentfault.com/a/1190000011239561

200 OK - 表示对应的GET,PUT,PATCH 或 DELETE操作成功。也可以用于POST表示没有创建成功。
201 Created - 表示POST创建成功
204 No Content - 表示一个成功的响应，body为空（比如 delete）
304 Not Modified - HTTP缓存
400 Bad Request - 表示request错误，比如body解析出错
401 Unauthorized - 提供了错误的认证信息。可以在这个错误之后触发认证功能。
403 Forbidden - 当认证成功，但是对应的用户没有对应资源的权限时。
404 Not Found - 表示请求一个并不存在的资源
405 Method Not Allowed - 一个认证的用户，调用了他所不允许使用的方法时。
410 Gone - 表示资源已经不可用。比如调用了一个老的API版本。
415 Unsupported Media Type - request提供了错误的content type
422 Unprocessable Entity - 验证错误
429 Too Many Requests - 因为负载限制，拒绝request时。
