(ns dots.node.fs.realpath-sync
  "Returns the resolved pathname.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link realpath }.
   Synchronous realpath(3) - return the canonicalized absolute pathname."
  (:require ["fs" :as fs]))

(defn native
  (^js [path]
   (.native fs/realpathSync path))
  (^js [path options]
   (.native fs/realpathSync path options)))
