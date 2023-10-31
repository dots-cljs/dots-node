(ns dots.node.fs.lstat-sync
  "Synchronous lstat(2) - Get file status. Does not dereference symbolic links."
  (:refer-clojure :exclude [apply name])
  (:require ["fs" :as fs]))

(defn apply
  "Calls the function, substituting the specified object for the this value of the function, and the specified array for the arguments of the function."
  (^js [this-arg]
   (.apply fs/lstatSync this-arg))
  (^js [this-arg arg-array]
   (.apply fs/lstatSync this-arg arg-array)))

(defn call
  "Calls a method of an object, substituting another object for the current object."
  ^js [this-arg & arg-array]
  (.. fs/lstatSync -call (apply fs/lstatSync (to-array (cons this-arg arg-array)))))

(defn bind
  "For a given function, creates a bound function that has the same body as the original function.
   The this object of the bound function is associated with the specified object, and has the specified initial parameters."
  ^js [this-arg & arg-array]
  (.. fs/lstatSync -bind (apply fs/lstatSync (to-array (cons this-arg arg-array)))))

(defn to-string
  "Returns a string representation of a function."
  ^js []
  (.toString fs/lstatSync))

(defn prototype
  ^js []
  (.-prototype fs/lstatSync))

(defn set-prototype!
  ^js [value]
  (set! (.-prototype fs/lstatSync) value))

(defn length
  ^js []
  (.-length fs/lstatSync))

(defn arguments
  ^js []
  (.-arguments fs/lstatSync))

(defn set-arguments!
  ^js [value]
  (set! (.-arguments fs/lstatSync) value))

(defn caller
  ^js []
  (.-caller fs/lstatSync))

(defn set-caller!
  ^js [value]
  (set! (.-caller fs/lstatSync) value))

(defn name
  "Returns the name of the function. Function names are read-only and can not be changed."
  ^js []
  (.-name fs/lstatSync))
