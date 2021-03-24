import axios from "axios";

/**
 * @param {*} error Error
 */
function getApiErrorMessage(error) {
  const status = error.response.status;
  if (status === 400) {
    // Bad Request
    return "bad request";
  }
  if (status === 401 && !error.response.data.useResponseMessage) {
    // Unauthorized
    return "Unauthorized";
  } else if (status === 403){
    //Forbidden
    if(error.response.data.message === "Bad credentials"){
      return "Bad credentials";
    } else if (error.response.data.message.indexOf("This session has been expired") === 0) {
      return "This session has been expired";
    } else {
      return error.response.data.message;
    }
  }
  // Others
  if (
    error.response &&
    error.response.data &&
    error.response.data.useResponseMessage
  ) {
    return error.response.data.message;
  }
  return "error";
}

/**
 * @param {*} response
 */
function handleSuccess(response) {
  return Promise.resolve(response);
}

/**
 * @param {*} error
 */
function handleError(error) {
  console.log(error);
  return Promise.reject(error);
}

/**
 * AxiosHelper
 */
const AxiosHelper = class {
  constructor() {
    this.http = axios.create({ baseURL: "/api" });

    this.http.interceptors.request.use(config => {

      if (typeof config.params === "undefined") {
        config.params = {};
      }
      if (typeof config.params === "object") {
        if (
          typeof URLSearchParams === "function" &&
          config.params instanceof URLSearchParams
        ) {
          config.params.append("_", Date.now());
        } else {
          config.params._ = Date.now();
        }
      }
      return config;
    });

    this.http.interceptors.response.use(
      response => handleSuccess(response),
      error => handleError(error)
    );
  }

  /**
   * @param {*} url
   * @param {*} params
   */
  get(url, params) {
    return this.http.get(url, { params: params });
  }

  /**
   * @param {*} url
   * @param {*} params
   */
  post(url, params) {
    return this.http.post(url, params);
  }

  /**
   * @param {*} url
   * @param {*} params
   * @param {*} config
   */
  configPost(url, params, config) {
    return this.http.post(url, params, config);
  }
  /**
   * @param {*} url
   * @param {*} params
   */
  put(url, params, config) {
    return this.http.put(url, params, config);
  }

  /**
   * @param {*} url
   * @param {*} params
   */
  delete(url, params) {
    return this.http.delete(url, { params: params });
  }
};

export const ApiHelper = new AxiosHelper();
