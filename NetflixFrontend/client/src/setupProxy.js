const { createProxyMiddleware } = require('http-proxy-middleware');



module.exports = function(app) {
  app.use(createProxyMiddleware('/netflixJava', { target: 'http://localhost:8090/netflix/',changeOrigin: true, pathRewrite: { '^/netflixJava': '' } }));
};