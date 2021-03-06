/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.graphrbac.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Permissions.
 */
public class PermissionsInner {
    /** The Retrofit service to perform REST calls. */
    private PermissionsService service;
    /** The service client containing this operation class. */
    private AuthorizationManagementClientImpl client;

    /**
     * Initializes an instance of PermissionsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public PermissionsInner(Retrofit retrofit, AuthorizationManagementClientImpl client) {
        this.service = retrofit.create(PermissionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Permissions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface PermissionsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Permissions listByResourceGroup" })
        @GET("subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/Microsoft.Authorization/permissions")
        Observable<Response<ResponseBody>> listByResourceGroup(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Permissions listForResource" })
        @GET("subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{parentResourcePath}/{resourceType}/{resourceName}/providers/Microsoft.Authorization/permissions")
        Observable<Response<ResponseBody>> listForResource(@Path("resourceGroupName") String resourceGroupName, @Path("resourceProviderNamespace") String resourceProviderNamespace, @Path(value = "parentResourcePath", encoded = true) String parentResourcePath, @Path(value = "resourceType", encoded = true) String resourceType, @Path("resourceName") String resourceName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Permissions listByResourceGroupNext" })
        @GET
        Observable<Response<ResponseBody>> listByResourceGroupNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Permissions listForResourceNext" })
        @GET
        Observable<Response<ResponseBody>> listForResourceNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param resourceGroupName The name of the resource group to get the permissions for. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;PermissionInner&gt; object if successful.
     */
    public PagedList<PermissionInner> listByResourceGroup(final String resourceGroupName) {
        ServiceResponse<Page<PermissionInner>> response = listByResourceGroupSinglePageAsync(resourceGroupName).toBlocking().single();
        return new PagedList<PermissionInner>(response.body()) {
            @Override
            public Page<PermissionInner> nextPage(String nextPageLink) {
                return listByResourceGroupNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param resourceGroupName The name of the resource group to get the permissions for. The name is case insensitive.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<PermissionInner>> listByResourceGroupAsync(final String resourceGroupName, final ListOperationCallback<PermissionInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByResourceGroupSinglePageAsync(resourceGroupName),
            new Func1<String, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(String nextPageLink) {
                    return listByResourceGroupNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param resourceGroupName The name of the resource group to get the permissions for. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<Page<PermissionInner>> listByResourceGroupAsync(final String resourceGroupName) {
        return listByResourceGroupWithServiceResponseAsync(resourceGroupName)
            .map(new Func1<ServiceResponse<Page<PermissionInner>>, Page<PermissionInner>>() {
                @Override
                public Page<PermissionInner> call(ServiceResponse<Page<PermissionInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param resourceGroupName The name of the resource group to get the permissions for. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listByResourceGroupWithServiceResponseAsync(final String resourceGroupName) {
        return listByResourceGroupSinglePageAsync(resourceGroupName)
            .concatMap(new Func1<ServiceResponse<Page<PermissionInner>>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(ServiceResponse<Page<PermissionInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByResourceGroupNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
    ServiceResponse<PageImpl<PermissionInner>> * @param resourceGroupName The name of the resource group to get the permissions for. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;PermissionInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listByResourceGroupSinglePageAsync(final String resourceGroupName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.listByResourceGroup(resourceGroupName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<PermissionInner>> result = listByResourceGroupDelegate(response);
                        return Observable.just(new ServiceResponse<Page<PermissionInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<PermissionInner>> listByResourceGroupDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<PermissionInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<PermissionInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param resourceGroupName The name of the resource group containing the resource. The name is case insensitive.
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param parentResourcePath The parent resource identity.
     * @param resourceType The resource type of the resource.
     * @param resourceName The name of the resource to get the permissions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;PermissionInner&gt; object if successful.
     */
    public PagedList<PermissionInner> listForResource(final String resourceGroupName, final String resourceProviderNamespace, final String parentResourcePath, final String resourceType, final String resourceName) {
        ServiceResponse<Page<PermissionInner>> response = listForResourceSinglePageAsync(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName).toBlocking().single();
        return new PagedList<PermissionInner>(response.body()) {
            @Override
            public Page<PermissionInner> nextPage(String nextPageLink) {
                return listForResourceNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param resourceGroupName The name of the resource group containing the resource. The name is case insensitive.
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param parentResourcePath The parent resource identity.
     * @param resourceType The resource type of the resource.
     * @param resourceName The name of the resource to get the permissions for.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<PermissionInner>> listForResourceAsync(final String resourceGroupName, final String resourceProviderNamespace, final String parentResourcePath, final String resourceType, final String resourceName, final ListOperationCallback<PermissionInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listForResourceSinglePageAsync(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName),
            new Func1<String, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(String nextPageLink) {
                    return listForResourceNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param resourceGroupName The name of the resource group containing the resource. The name is case insensitive.
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param parentResourcePath The parent resource identity.
     * @param resourceType The resource type of the resource.
     * @param resourceName The name of the resource to get the permissions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<Page<PermissionInner>> listForResourceAsync(final String resourceGroupName, final String resourceProviderNamespace, final String parentResourcePath, final String resourceType, final String resourceName) {
        return listForResourceWithServiceResponseAsync(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName)
            .map(new Func1<ServiceResponse<Page<PermissionInner>>, Page<PermissionInner>>() {
                @Override
                public Page<PermissionInner> call(ServiceResponse<Page<PermissionInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param resourceGroupName The name of the resource group containing the resource. The name is case insensitive.
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param parentResourcePath The parent resource identity.
     * @param resourceType The resource type of the resource.
     * @param resourceName The name of the resource to get the permissions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listForResourceWithServiceResponseAsync(final String resourceGroupName, final String resourceProviderNamespace, final String parentResourcePath, final String resourceType, final String resourceName) {
        return listForResourceSinglePageAsync(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName)
            .concatMap(new Func1<ServiceResponse<Page<PermissionInner>>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(ServiceResponse<Page<PermissionInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listForResourceNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
    ServiceResponse<PageImpl<PermissionInner>> * @param resourceGroupName The name of the resource group containing the resource. The name is case insensitive.
    ServiceResponse<PageImpl<PermissionInner>> * @param resourceProviderNamespace The namespace of the resource provider.
    ServiceResponse<PageImpl<PermissionInner>> * @param parentResourcePath The parent resource identity.
    ServiceResponse<PageImpl<PermissionInner>> * @param resourceType The resource type of the resource.
    ServiceResponse<PageImpl<PermissionInner>> * @param resourceName The name of the resource to get the permissions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;PermissionInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listForResourceSinglePageAsync(final String resourceGroupName, final String resourceProviderNamespace, final String parentResourcePath, final String resourceType, final String resourceName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (parentResourcePath == null) {
            throw new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null.");
        }
        if (resourceType == null) {
            throw new IllegalArgumentException("Parameter resourceType is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.listForResource(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<PermissionInner>> result = listForResourceDelegate(response);
                        return Observable.just(new ServiceResponse<Page<PermissionInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<PermissionInner>> listForResourceDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<PermissionInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<PermissionInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;PermissionInner&gt; object if successful.
     */
    public PagedList<PermissionInner> listByResourceGroupNext(final String nextPageLink) {
        ServiceResponse<Page<PermissionInner>> response = listByResourceGroupNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<PermissionInner>(response.body()) {
            @Override
            public Page<PermissionInner> nextPage(String nextPageLink) {
                return listByResourceGroupNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<PermissionInner>> listByResourceGroupNextAsync(final String nextPageLink, final ServiceFuture<List<PermissionInner>> serviceFuture, final ListOperationCallback<PermissionInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByResourceGroupNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(String nextPageLink) {
                    return listByResourceGroupNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<Page<PermissionInner>> listByResourceGroupNextAsync(final String nextPageLink) {
        return listByResourceGroupNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<PermissionInner>>, Page<PermissionInner>>() {
                @Override
                public Page<PermissionInner> call(ServiceResponse<Page<PermissionInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listByResourceGroupNextWithServiceResponseAsync(final String nextPageLink) {
        return listByResourceGroupNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<PermissionInner>>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(ServiceResponse<Page<PermissionInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByResourceGroupNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource group.
     *
    ServiceResponse<PageImpl<PermissionInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;PermissionInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listByResourceGroupNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listByResourceGroupNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<PermissionInner>> result = listByResourceGroupNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<PermissionInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<PermissionInner>> listByResourceGroupNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<PermissionInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<PermissionInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;PermissionInner&gt; object if successful.
     */
    public PagedList<PermissionInner> listForResourceNext(final String nextPageLink) {
        ServiceResponse<Page<PermissionInner>> response = listForResourceNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<PermissionInner>(response.body()) {
            @Override
            public Page<PermissionInner> nextPage(String nextPageLink) {
                return listForResourceNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<PermissionInner>> listForResourceNextAsync(final String nextPageLink, final ServiceFuture<List<PermissionInner>> serviceFuture, final ListOperationCallback<PermissionInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listForResourceNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(String nextPageLink) {
                    return listForResourceNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<Page<PermissionInner>> listForResourceNextAsync(final String nextPageLink) {
        return listForResourceNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<PermissionInner>>, Page<PermissionInner>>() {
                @Override
                public Page<PermissionInner> call(ServiceResponse<Page<PermissionInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;PermissionInner&gt; object
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listForResourceNextWithServiceResponseAsync(final String nextPageLink) {
        return listForResourceNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<PermissionInner>>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(ServiceResponse<Page<PermissionInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listForResourceNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all permissions the caller has for a resource.
     *
    ServiceResponse<PageImpl<PermissionInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;PermissionInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<PermissionInner>>> listForResourceNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listForResourceNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<PermissionInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<PermissionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<PermissionInner>> result = listForResourceNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<PermissionInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<PermissionInner>> listForResourceNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<PermissionInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<PermissionInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
