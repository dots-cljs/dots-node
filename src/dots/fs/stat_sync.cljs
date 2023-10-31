(ns dots.fs.stat-sync
  "Synchronous stat(2) - Get file status."
  (:refer-clojure :exclude [apply name])
  (:require ["fs" :as fs]))

(defn apply
  "Calls the function, substituting the specified object for the this value of the function, and the specified array for the arguments of the function."
  (^js [this-arg]
   (.apply fs/statSync this-arg))
  (^js [this-arg arg-array]
   (.apply fs/statSync this-arg arg-array)))

(defn call
  "Calls a method of an object, substituting another object for the current object."
  ^js [this-arg & arg-array]
  (.. fs/statSync -call (apply fs/statSync (to-array (cons this-arg arg-array)))))

(defn bind
  "For a given function, creates a bound function that has the same body as the original function.
   The this object of the bound function is associated with the specified object, and has the specified initial parameters."
  ^js [this-arg & arg-array]
  (.. fs/statSync -bind (apply fs/statSync (to-array (cons this-arg arg-array)))))

(defn to-string
  "Returns a string representation of a function."
  ^js []
  (.toString fs/statSync))

(defn prototype
  ^js []
  (.-prototype fs/statSync))

(defn set-prototype!
  ^js [value]
  (set! (.-prototype fs/statSync) value))

(defn length
  ^js []
  (.-length fs/statSync))

(defn arguments
  ^js []
  (.-arguments fs/statSync))

(defn set-arguments!
  ^js [value]
  (set! (.-arguments fs/statSync) value))

(defn caller
  ^js []
  (.-caller fs/statSync))

(defn set-caller!
  ^js [value]
  (set! (.-caller fs/statSync) value))

(defn name
  "Returns the name of the function. Function names are read-only and can not be changed."
  ^js []
  (.-name fs/statSync))
