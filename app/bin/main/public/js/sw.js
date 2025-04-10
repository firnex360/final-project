let cacheName = "core" // Whatever name
// Pass all assets here
// This example use a folder named «/core» in the root folder
// It is mandatory to add an icon (Important for mobile users)
let filesToCache = [
  "/",
  "../listArticle.html",
  "../createArticle.html",
  "../createUser.html",
  "../createShortURL.html",
  "../listShortUrl.html",
  "../login.html",
  "../urlAccessLog.html",
  "../viewArticle.html",
  "../viewUser.html",
]

self.addEventListener("install", function(e) {
  e.waitUntil(
    caches.open(cacheName).then(function(cache) {
      return cache.addAll(filesToCache)
    })
  )
})

self.addEventListener("fetch", function(e) {
  e.respondWith(
    caches.match(e.request).then(function(response) {
      return response || fetch(e.request)
    })
  )
})