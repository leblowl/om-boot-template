(ns project.app
  (:require [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]))

(def app-state (atom {}))

(defn app [data owner]
  (om/component
    (html [:div "Hello_World"])))

(defn render []
  (om/root app app-state {:target (.getElementById js/document "root")}))

(render)
