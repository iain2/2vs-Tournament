class Request {

  get(url) {
    return fetch(url).then((res) => { res.json() })
  }

  post(url, payload) {
    return fetch(url, {
      method: "POST",
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    })
  }

  put(url, payload) {
    return fetch(url, {
      method: "PUT",
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    })
  }

  delete(url) {
    return fetch(url, {
      method: "DELETE",
      headers: { 'Content-Type': 'application/json' }
    })
  }


}

export default Request;
