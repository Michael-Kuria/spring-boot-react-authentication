export function handleLogin(values) {
  return fetch("/login", {
    headers: {
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(values),
  });
}
